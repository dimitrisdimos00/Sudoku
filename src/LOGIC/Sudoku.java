package LOGIC;

import GUI.AllOfFrames.SudokuFrame;
import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Sudoku extends Logic{
    public Sudoku (boolean isNumerical, SudokuFrame sudokuFrame, ArrayList<Integer> wantedPuzzles){
        super(1,isNumerical, sudokuFrame);
        ReadFile readFile = new ReadFile(1);
        try {
            setSudoku(getArrayConverter().arrayToCharMatrix(readFile.getRandomPuzzle(wantedPuzzles), isNumerical));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
