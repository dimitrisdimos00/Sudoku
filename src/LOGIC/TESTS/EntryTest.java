package LOGIC.TESTS;

import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {

    @Test
    void classicPuzzleSolved() {
        Entry entry = new Entry("Dimitris");
        entry.classicPuzzleSolved(2);
        assertFalse(entry.getUnsolvedClassicPuzzles().contains(2));
    }

    @Test
    void killerPuzzleSolved() {
        Entry entry = new Entry("Dimitris");
        entry.killerPuzzleSolved(2);
        assertFalse(entry.getUnsolvedKillerPuzzles().contains(2));
    }

    @Test
    void increaseWins() {
        Entry entry = new Entry("Dimitris");
        entry.increaseWins();
        assertEquals(1, entry.getWins());
    }

    @Test
    void increaseLoses() {
        Entry entry = new Entry("Dimitris");
        entry.increaseLoses();
        assertEquals(1, entry.getLosses());
    }
}