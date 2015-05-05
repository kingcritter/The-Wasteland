// Crispin A. Stichart
// Sudoku Solver
// May 3rd, 2015
// Usage: java SudokuSolver mypuzzle.txt

import java.util.*;
import java.io.*;

public class SudokuSolver {
    // This is a program that solves a given sudoku puzzle, yay!
    // A note about how it works: the puzzle is represented by a 9x9
    // 2 dimensional array. Cells are referenced in two ways: first, 
    // by [column][row], and second, by an integer; 0 is the position
    // [0][0] and 81 is the position [8][8]. The method getCellCoords()
    // takes an integer and translates it into an ordered pair like so:
    // [column, row].

    static int[][] puzzle = new int[9][9]; //the actual puzzle
    static int[] blacklist = new int[81]; 
    // if a cell is filled in when the puzzle is loaded, blacklist[cell] is
    // set equal to the value of that cell.

    public static void main(String[] args) throws FileNotFoundException {
        if (handleArgs(args)) {
            if (solve(0)) {
                printPuzzle();
            }
            else {
                System.out.println("Puzzle unsolvable!");
            }
        }
    }

    public static boolean solve(int cell) {
        // This is the the meat of the program, the recursive function

        // if we've reached the end of the puzzle:
        if (getCellCoords(cell)[0] == -1) {
            return true;
        }
        // if the current cell was filled in from the beginning:
        else if (blacklist[cell] != 0) {
            if (solve(cell+1))
                return true;
            return false;
        }

        else {
            for (int i = 1; i <= 9; i++) {
                if (canPlace(getCellCoords(cell), i)) {
                    place(getCellCoords(cell), i);                 
                    if (solve(cell+1)) {
                        return true;
                    }
                    remove(getCellCoords(cell));
                }
            }
            return false;
        }
    }

    public static boolean handleArgs(String[] args) throws FileNotFoundException {
        // This function loads the given file into the puzzle array, after checking 
        // to make sure it exists and whatnot

        if (args.length < 1) {
            System.out.println("Please specify a puzzle to solve.");
            System.exit(0);
        }

        File f = new File(args[0]);
        if (!f.canRead()) {
            System.out.println("Looks like " + args[0] + " doesn't exist.");
            System.exit(0);
        }
        // enters the file info into the puzzle array
        Scanner puzzleFile = new Scanner(f);
        int cell = 0;
        while (puzzleFile.hasNextInt()) {
            int number = puzzleFile.nextInt();
            if (number > 0)
                blacklist[cell] = number;
            place(getCellCoords(cell), number);
            cell++;
        }
        return true;
    }

    public static int[] getCellCoords(int x) {
        // This is a function to translate an int into an (x,y)
        // cooridinate pair on a 9x9 grid. If the integer results
        // in a pair that's outside the grid, than it returns (-1, -1)
        int y = 0;
        while (x > 8) {
            x = x-9;
            y++;
        }
        if (y > 8)
            return new int[] {-1, -1};
        else
            return new int[] {x, y};
    }

    public static void printPuzzle() {
        // prints the puzzle to the console
        for (int y = 0; y <= 8; y++) {
            for (int x = 0; x <=8; x++) {
                System.out.print(puzzle[x][y] + " ");
            }
            System.out.println();
        }
    }

    public static boolean canPlace(int[] cellCoords, int number) {
        // Checks to see if the number is a legal placement. 

        int col = cellCoords[0];
        int row = cellCoords[1];
        //these next four ints are for the 3x3 squares
        int gridCol = 0;
        int gridRow = 0;
        int gridStartX = (int)(col / 3) * 3; // left of current 3x3 grid
        int gridStartY = (int)(row / 3) * 3; // top of current 3x3 grid
        for (int rowcol = 0; rowcol <= 8; rowcol++) {
            // sees if it matches one in the same row or column
            if ((puzzle[rowcol][row] == number) || 
                (puzzle[col][rowcol] == number)) {
                return false;
            }
            // sees if it matches 3x3 grid
            // Technically, this part doesn't have to be inside this for loop, 
            // because it doesn't use rowcol, but it does need to run 9 times,
            // so I didn't want to bother making another loop.
            if (puzzle[gridStartX + gridCol][gridStartY + gridRow] == number)
                return false;
            gridCol++;
            if (gridCol > 2) {
                gridCol = 0;
                gridRow++;
            }
        }
        //guess we can place it!
        return true;
    }

    public static void place(int[] cellCoords, int i) {
        puzzle[cellCoords[0]][cellCoords[1]] = i;
    }

    public static void remove(int[] cellCoords) {
        puzzle[cellCoords[0]][cellCoords[1]] = 0;
    }

}