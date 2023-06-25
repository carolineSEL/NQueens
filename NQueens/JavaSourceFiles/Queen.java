// Class: Queen
//
// Author: Alyce Brady
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

import java.awt.Color;
import edu.kzoo.grid.ColorBlock;
import edu.kzoo.grid.Grid;
import edu.kzoo.grid.Location;

/**
 *  Environment-Based Applications:<br>
 *
 *    A Queen object represents a queen in the N Queens Problem.
 *
 *  @author Alyce Brady
 *  @version 1 November 2002
 **/
public class Queen extends ColorBlock
{
    private static Color queenColor = Color.red;

    /** Constructs a queen at the specified location on an N x N
     *  "chessboard."
     *  @param board   the board on which to place this queen
     *  @param loc     the location of this queen
     **/
    public Queen(Grid board, Location loc)
    {
        super(queenColor, board, loc);
    }

    /** Defines the color to make all queens. **/
    public static void setQueenColor(Color col)
    {
        queenColor = col;
    }
}
