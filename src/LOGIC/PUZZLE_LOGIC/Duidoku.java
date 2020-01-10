package LOGIC.PUZZLE_LOGIC;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.util.Random;
/**
 * The Duidoku class extends the Logic class. It contains one method called computerPlays.
 *
 * @author Δημήτρης Δήμος
 */
public class Duidoku extends Logic {
    /**
     * Super with sudoku_selection = 3, and the option for the puzzle being numerical or not is called. The supdoku 2D array
     * is set to zeros
     * @param isNumerical true for numerical, false for wordoku
     */
    public Duidoku(boolean isNumerical){
        super(3, isNumerical);
        setSudoku(getArrayConverter().matrixToZeros());
    }

    /**
     * In this method the computer finds a random row, a random column and a random elements and tries to insert it in
     * the puzzle, if that it is possible. If that is not the case, it finds a new random row, column and element and tries
     * until the element is inserted. If the sudokuFrame cell is black, the position is different than '0' or the element can
     * not be inserted in that position, the values are being computed again.
     * @param sudokuFrame the sudokuFrame is needed in order for computerPlays to know if a cell is black. In that case
     *                    no element can be inserted in that position
     */
    public void computerPlays(SudokuFrame sudokuFrame){
        Random random = new Random();
        int n = getN();
        int randomRow = random.nextInt(n);
        int randomColumn = random.nextInt(n);
        char randomElement;
        if (isNumerical()) {
            randomElement = (char)(random.nextInt(n) + 1 + '0');
        }
        else {
            randomElement = getArrayConverter().intToChar(random.nextInt(n) + 1);
        }

        while (sudokuFrame.getTheField()[randomRow][randomColumn].getBackground().equals(Color.black) ||getSudoku()[randomRow][randomColumn] != '0' || !insertElement(randomRow, randomColumn, randomElement)){
            randomRow = random.nextInt(n);
            randomColumn = random.nextInt(n);
            if (isNumerical()) {
                randomElement = (char) (random.nextInt(n + 1) + '0');
            }
            else {
                randomElement = getArrayConverter().intToChar(random.nextInt(n + 1));
            }
        }
    }
}
