package LOGIC.PUZZLE_LOGIC;

import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
/**
 * The KillerSudoku class extends the Logic class. It contains a constructor to Read a puzzle from the file and a method
 * that returns a HashSet with the unique numbers in the int[][] array sums that shows the sum of every cell. For example
 * if sums[0][0] and sums[0][1] are both 4, that means that in the original 2D char array "sudoku", sudoku[0][0] + sudoku[0][1] =
 * = 4.
 *
 * @author Δημήτρης Δήμος
 */
public class KillerSudoku extends Logic {
    private int[][] sums;
    private int randomPuzzleIndex;
    //----------------------------------------
    public int[][] getSums() {
        return sums;
    }
    public int getRandomPuzzleIndex() {
        return randomPuzzleIndex;
    }

    public void setSums(int[][] sums) {
        this.sums = sums;
    }
    public void setRandomPuzzleIndex(int randomPuzzleIndex) {
        this.randomPuzzleIndex = randomPuzzleIndex;
    }
    //-----------------------------------------

    /**
     * After super with sudoku_selection = 2, and the option for the puzzle being numerical or not is called, a ReadFile
     * object is created in order to get a random Puzzle from the file, and convert it to a 2d int array with Logic's ArrayConverter
     * arrayToIntMatrix method. The randomPuzzleIndex shows which puzzle has been selected.
     * @param isNumerical true for numerical, false for wordoku
     * @param wantedPuzzles an ArrayList object with the unsolved puzzles
     */
    public KillerSudoku(boolean isNumerical, ArrayList<Integer> wantedPuzzles){
        super(2, isNumerical);
        ReadFile readFile = new ReadFile(2);
        try {
            sums = getArrayConverter().arrayToIntMatrix(readFile.getRandomPuzzle(wantedPuzzles));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setSudoku(getArrayConverter().matrixToZeros());
        randomPuzzleIndex = readFile.getRandomPuzzleIndex();
    }

    /**
     * Returns all the unique sums of the sums 2D int array.
     * @return HashSet with unique numbers
     */
    public HashSet<Integer> getUniqueNumbers () {
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < getN(); i++) {
            for (int j = 0; j < getN(); j++) {
                uniqueNumbers.add(sums[i][j]);
            }
        }
        return uniqueNumbers;
    }
}
