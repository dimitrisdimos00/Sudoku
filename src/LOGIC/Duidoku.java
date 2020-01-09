package LOGIC;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.util.Random;

public class Duidoku extends Logic{
    private SudokuFrame sudokuFrame;

    //-------------------------------------

    public SudokuFrame getSudokuFrame() {
        return sudokuFrame;
    }

    public void setSudokuFrame(SudokuFrame sudokuFrame) {
        this.sudokuFrame = sudokuFrame;
    }

    //--------------------------------------

    public Duidoku(boolean isNumerical, SudokuFrame sudokuFrame){
        super(3, isNumerical);
        setSudoku(getArrayConverter().matrixToZeros());
        this.sudokuFrame = sudokuFrame;
    }

    public void computerPlays(){
        Random random = new Random();
        int randomRow = random.nextInt(getN());
        int randomColumn = random.nextInt(getN());
        char randomElement;
        if (isNumerical()) {
            randomElement = (char)(random.nextInt(getN()) + 1 + '0');
        }
        else {
            randomElement = getArrayConverter().intToChar(random.nextInt(getN()) + 1);
        }

        while (getSudokuFrame().getTheField()[randomRow][randomColumn].getBackground().equals(Color.black) ||getSudoku()[randomRow][randomColumn] != '0' || !insertElement(randomRow, randomColumn, randomElement)){
            randomRow = random.nextInt(getN());
            randomColumn = random.nextInt(getN());
            if (isNumerical()) {
                randomElement = (char) (random.nextInt(getN() + 1) + '0');
            }
            else {
                randomElement = getArrayConverter().intToChar(random.nextInt(getN() + 1));
            }
        }
    }
}
