package LOGIC;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.util.Random;

public class Duidoku extends Logic{
    private ArrayConverter arrayConverter = new ArrayConverter(getN());
    public Duidoku(boolean isNumerical, SudokuFrame sudokuFrame){
        super(3, isNumerical, sudokuFrame);
        setSudoku(arrayConverter.matrixToZeros());
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
            randomElement = arrayConverter.intToChar(random.nextInt(getN()) + 1);
        }

        while (getaSudokuFrame().getTheField()[randomRow][randomColumn].getBackground().equals(Color.black) ||getSudoku()[randomRow][randomColumn] != '0' || !insertElement(randomRow, randomColumn, randomElement)){
            randomRow = random.nextInt(getN());
            randomColumn = random.nextInt(getN());
            if (isNumerical()) {
                randomElement = (char) (random.nextInt(getN() + 1) + '0');
            }
            else {
                randomElement = arrayConverter.intToChar(random.nextInt(getN() + 1));
            }
        }
    }
}
