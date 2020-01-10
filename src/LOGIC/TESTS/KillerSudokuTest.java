package LOGIC.TESTS;

import LOGIC.PUZZLE_LOGIC.KillerSudoku;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class KillerSudokuTest {

    @Test
    void getUniqueNumbers() {
        ArrayList<Integer> wantedPuzzles = new ArrayList<>();
        wantedPuzzles.add(0);
        KillerSudoku killerSudoku = new KillerSudoku(true, wantedPuzzles);
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers.add(11);
        uniqueNumbers.add(25);
        uniqueNumbers.add(14);
        uniqueNumbers.add(9);
        uniqueNumbers.add(12);
        uniqueNumbers.add(15);
        uniqueNumbers.add(4);
        uniqueNumbers.add(6);
        uniqueNumbers.add(40);
        uniqueNumbers.add(3);
        uniqueNumbers.add(8);
        uniqueNumbers.add(38);
        uniqueNumbers.add(17);
        uniqueNumbers.add(13);
        uniqueNumbers.add(7);
        uniqueNumbers.add(10);
        uniqueNumbers.add(26);
        assertEquals(uniqueNumbers, killerSudoku.getUniqueNumbers());
    }
}