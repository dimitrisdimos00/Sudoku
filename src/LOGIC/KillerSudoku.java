package LOGIC;

import GUI.AllOfFrames.SudokuFrame;
import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

public class KillerSudoku extends Logic {
    private int[][] sums;

    public KillerSudoku(boolean isNumerical, SudokuFrame sudokuFrame, ArrayList<Integer> wantedPuzzles){
        super(2, isNumerical, sudokuFrame);
        ReadFile readFile = new ReadFile(2);
        ArrayConverter arrayConverter = new ArrayConverter(getN());
        try {
            int[][] sums = arrayConverter.arrayToIntMatrix(readFile.getRandomPuzzle(wantedPuzzles));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        setSudoku(arrayConverter.matrixToZeros());
    }

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
