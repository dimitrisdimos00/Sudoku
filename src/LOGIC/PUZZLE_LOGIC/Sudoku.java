package LOGIC.PUZZLE_LOGIC;

import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;
import LOGIC.PUZZLE_LOGIC.Logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Sudoku extends Logic {
    public Sudoku (boolean isNumerical, ArrayList<Integer> wantedPuzzles){
        super(1, isNumerical);
        ReadFile readFile = new ReadFile(1);
        try {
            setSudoku(getArrayConverter().arrayToCharMatrix(readFile.getRandomPuzzle(wantedPuzzles), isNumerical));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
