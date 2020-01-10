package LOGIC.PUZZLE_LOGIC;

import LOGIC.PUZZLE_FILE_MANAGEMENT.ReadFile;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;

public class KillerSudoku extends Logic {
    private int[][] sums;
    //----------------------------------------
    public int[][] getSums() {
        return sums;
    }

    public void setSums(int[][] sums) {
        this.sums = sums;
    }
    //-----------------------------------------
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
