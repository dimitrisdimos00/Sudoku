package LOGIC.PUZZLE_LOGIC;

import GUI.AllOfFrames.SudokuFrame;
import LOGIC.PUZZLE_LOGIC.Logic;

import java.awt.*;
import java.util.Random;
/**
 * The Duidoku class extends the Logic class. It contains one method called computerPlays.
 *
 * @author Δημήτρης Δήμος
 */
public class Duidoku extends Logic {
    /**
     * Super with sudoku_selection = 3, and the option for the puzzle being numerical or not is called
     * @param isNumerical true for numerical, false for wordoku
     */
    public Duidoku(boolean isNumerical){
        super(3, isNumerical);
        setSudoku(getArrayConverter().matrixToZeros());
    }

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
