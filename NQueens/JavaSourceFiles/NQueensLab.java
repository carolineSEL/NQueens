// Class: NQueensLab
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

import javax.swing.JMenu;

import edu.kzoo.grid.display.ColorBlockDisplay;
import edu.kzoo.grid.display.DisplayMap;
import edu.kzoo.grid.gui.GridAppFrame;
import edu.kzoo.grid.gui.nuggets.BasicHelpMenu;
import edu.kzoo.grid.gui.nuggets.MinimalFileMenu;

/**
 *  Environment-Based Applications:<br>
 *
 *    The NQueensLab class implements the N Queens problem.
 *
 *  @author Alyce Brady
 *  @version 1 September 2002
 **/

public class NQueensLab
{
    // Specify dimensions of grid display and individual cell size.
    private static final int DISPLAY_WIDTH = 400;
    private static final int DISPLAY_HEIGHT = 400;
    private static final int MIN_CELL_SIZE = 20;

    // Specify the grid's background color and highlight color.
    private static final Color BACKGROUND_COLOR = new Color(0, 155, 255);
    private static final Color HIGHLIGHT_COLOR = Color.red;

    /**
     *  Starts the N Queens program.
     *  The String arguments (args) are not used in this application.
     **/
    public static void main(String[] args)
    {
        // Construct the object for solving the N Queens problem and
        // a window to display it in.
        GridAppFrame display = new GridAppFrame();
        display.includeMenu(new MinimalFileMenu());
        JMenu helpMenu = new BasicHelpMenu("NQueens",
            "Caroline Lamb",
            "with assistance from (whom? e.g., Alyce Brady)",
            "3 November 2021", "file:NQueensHelp.html");
        display.includeMenu(helpMenu);
        display.includeSpeedSlider();
        display.constructWindowContents("N Queens Problem", BACKGROUND_COLOR, 
                                DISPLAY_WIDTH, DISPLAY_HEIGHT, MIN_CELL_SIZE);
        Queen.setQueenColor(HIGHLIGHT_COLOR);
        NQueens queens = new NQueens(8, display);

        // Specify how to display objects in the grid.
        DisplayMap.associate("Queen", new ColorBlockDisplay());
        // OR, DisplayMap.associate("Queen", new ScaledImageDisplay("GoldCrown.gif"));

        // Solve the N Queens Problem.
        queens.solve();
    }

}
