package LOGIC.PUZZLE_LOGIC;

import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;
import LOGIC.PUZZLE_LOGIC.Logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * The Sudoku class extends the Logic class. It contains a constructor to Read a puzzle from the file.
 *
 * @author Δημήτρης Δήμος
 */
public class Sudoku extends Logic {
    private int randomPuzzleIndex;
    //--------------------------------------
    public int getRandomPuzzleIndex() {
        return randomPuzzleIndex;
    }

    public void setRandomPuzzleIndex(int randomPuzzleIndex) {
        this.randomPuzzleIndex = randomPuzzleIndex;
    }
    //--------------------------------------

    /**
     * After super with sudoku_selection = 1, and the option for the puzzle being numerical or not is called, a ReadFile
     * object is created in order to get a random Puzzle from the file, and convert it to a 2d char array with Logic's ArrayConverter
     * arrayToCharMatrix method. The randomPuzzleIndex shows which puzzle has been selected.
     * @param isNumerical true for numerical, false for wordoku
     * @param wantedPuzzles an ArrayList object with the unsolved puzzles
     */
    public Sudoku (boolean isNumerical, ArrayList<Integer> wantedPuzzles){
        super(1, isNumerical);
        ReadFile readFile = new ReadFile(1);
        try {
            setSudoku(getArrayConverter().arrayToCharMatrix(readFile.getRandomPuzzle(wantedPuzzles), isNumerical));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        randomPuzzleIndex = readFile.getRandomPuzzleIndex();
    }
}
