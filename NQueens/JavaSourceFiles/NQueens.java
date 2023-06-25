// Class: NQueens
//
// Author: Your Name Here
//
// License Information:
//   This class is free software; you can redistribute it and/or modify
//   it under the terms of the GNU General Public License as published by
//   the Free Software Foundation.
//
//   This class is distributed in the hope that it will be useful,
//   but WITHOUT ANY WARRANTY; without even the implied warranty of
//   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//   GNU General Public License for more details.

import edu.kzoo.grid.BoundedGrid;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;
import edu.kzoo.grid.display.GridDisplay;

/**
 *  Environment-Based Applications:<br>
 *
 *    The NQueens class implements the N Queens problem.
 *
 *  @author Caroline Lamb (assisted by Collaboration Center on 11/4/2021)
 *                          (based on a template provided by Alyce Brady)
 *  @version 3 November 2021
 **/

public class NQueens
{
    // Instance Variables: Encapsulated data for EACH NQueens problem
    private Grid board;
    private GridDisplay display;

    // constructor

    /** Constructs an object that solves the N Queens Problem.
     *    @param n the number of queens to be placed on an
     *              <code>n</code> x <code>n</code> board
     *    @param d an object that knows how to display an 
     *              <code>n</code> x <code>n</code> board and
     *              the queens on it
     **/
    public NQueens(int n, GridDisplay d)
    {
        board = new BoundedGrid(n, n);
        display = d;
        display.setGrid(board);
        display.showGrid();
    }

    // methods

    /** Returns the number of queens to be placed on the board. **/
    public int numQueens()
    {
        return board.numRows();
    }

    /** Solves (or attempts to solve) the N Queens Problem. **/
    public boolean solve()
    {
        placeQueen(numQueens()-1);
        return true;
    }

    /** Attempts to place the <code>q</code>th queen on the board.
     *  (Precondition: <code>0 <= q < numQueens()</code>)
     *    @param q index of next queen to place
     **/
    private boolean placeQueen(int q)
    {
        // Queen q is placed in row q.  The only question is
        // which column she will be in.  Try them in turn.
        // Whenever we find a column that could work, put her
        // there and see if we can place the rest of the queens.

        // base case- when all colmuns are filled, stop recursion--the problem
        // is solved!
        if ( q == -1 )
        {
            display.showGrid();
            return true;
        }
        else
        {
            // check grid by columns for a location to place the queen.
            for ( int col = 0; col < board.numCols(); col++ )
            {
                Location loc = new Location(q, col);
                // if it is a valid location place the queen. 
                if ( locationIsOK(loc) == true )
                {
                    addQueen(loc);
                    display.showGrid();
                    // if the queen was sucessfully placed in the previous
                    // row, return true to place next queen. 
                    if ( placeQueen(q-1) )
                    {
                        return true;
                    }
                    // otherwise, remove that queen, method will be called
                    // again so that previous queen can be placed in a 
                    // different spot. 
                    else
                    {
                        removeQueen(new Location(q,col));
                        display.showGrid();
                    }
                }
            } 
        }
        return false;
    }

    /** Determines whether a queen can be placed at the specified
     *  location.
     *    @param loc  the location to test
     **/
    private boolean locationIsOK(Location loc)
    {
        // Verify that another queen can't attack this location.
        // (Only queens in previous rows have been placed.)
        
        // variables representing the row and column of the location being
        // passed as a parameter. 
        int row;
        int col;
        // check that there are no other queens in this column.
        for ( int i = 0; i < board.numCols(); i++ )
        {
            if (!board.isEmpty(new Location(loc.row(), i)))
            {
                return false;
            }
        }
        // check that there are no other queens in this row.
        for ( int i = 0; i < board.numRows(); i++ )
        {
            if(!board.isEmpty(new Location(i, loc.col())))
            {
                return false;
            }
        }
        // check that there are no other queens in the diagonal from bottom 
        // left to top right. 
        for ( row = loc.row(), col = loc.col(); row >= 0 && 
                                            col<board.numCols(); row--, col++)
        {
            Location l = new Location(row, col);
            if ( !board.isEmpty(l) )
            {
                return false;
            }
        }
        // check that there are no queens in the diagonal from bottom right 
        // corner to top left corner
        for (row = loc.row(), col = loc.col(); row>=0 && col>=0; row--, 
                col--)
        {
            if (!board.isEmpty(new Location(row, col)))
            {
                return false;
            }
        }
        // check that there are no queens in the diagonal from top left corner
        // to bottom right corner 
        for (row = loc.row(), col = loc.col(); row < board.numRows() && 
                                        col < board.numCols(); row++, col++)
        {
            if (!board.isEmpty(new Location(row, col)))
            {
                return false;
            }
        }
        // check that there are no queens in the diagonal from top right to 
        // bottom left corner 
        for (row = loc.row(), col = loc.col(); row < board.numRows() && 
                                                    col >= 0; row++, col--)
        {
            if (!board.isEmpty(new Location(row, col)))
            {
                return false;
            }
        }
        // otherwise, return true. 
        return true;
    }

    /** Adds a queen to the specified location.
     *    @param loc  the location where the queen should be placed
     **/
    private void addQueen(Location loc)
    {
        new Queen(board, loc);      // queens add themselves to the board
    }

    /** Removes a queen from the specified location.
     *    @param loc  the location where the queen should be removed
     **/
    private void removeQueen(Location loc)
    {
        board.remove(loc);
        display.showGrid();
    }

}
