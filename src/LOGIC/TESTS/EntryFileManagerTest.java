package LOGIC.TESTS;

import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;
import LOGIC.ENTRY_FILE_MANAGEMENT.EntryFileManager;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EntryFileManagerTest {

    @Test
    void addEntry() {
        Entry entry = new Entry("A");
        EntryFileManager entryFileManager = new EntryFileManager();
        entryFileManager.addEntry(entry);
        ArrayList<Entry> allEntries = entryFileManager.getAllEntries();
        assertEquals(entry.toString(), allEntries.get(0).toString());
        entryFileManager.emptyFile();
    }

    @Test
    void getAllEntries() {

        Entry entry1 = new Entry("A");
        Entry entry2 = new Entry("B");
        ArrayList<Entry> expected = new ArrayList<>();
        expected.add(entry1);
        expected.add(entry2);

        EntryFileManager entryFileManager = new EntryFileManager();
        entryFileManager.addEntry(entry1);
        entryFileManager.addEntry(entry2);
        ArrayList<Entry> actual = entryFileManager.getAllEntries();
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).toString(), actual.get(i).toString());
        }
        entryFileManager.emptyFile();
    }

    @Test
    void getEntry() {
        Entry expected = new Entry("A");
        EntryFileManager entryFileManager = new EntryFileManager();
        entryFileManager.addEntry(expected);
        Entry actual = entryFileManager.getEntry("A");
        assertEquals(expected.toString(), actual.toString());
        entryFileManager.emptyFile();
    }

    @Test
    void updateEntries() {
        Entry entry = new Entry("A");
        EntryFileManager entryFileManager = new EntryFileManager();
        ArrayList<Entry> expected = new ArrayList<>();
        expected.add(entry);
        entryFileManager.updateEntries(expected);
        assertEquals(expected.get(0).toString(), entryFileManager.getAllEntries().get(0).toString());
        entryFileManager.emptyFile();
    }

    @Test
    void updateEntry() {
        Entry entry = new Entry("A");
        EntryFileManager entryFileManager = new EntryFileManager();
        entryFileManager.updateEntry(entry);
        assertEquals(entry.toString(), entryFileManager.getEntry(entry.getName()).toString());

        entryFileManager.emptyFile();
    }
}