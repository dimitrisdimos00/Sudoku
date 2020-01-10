package LOGIC.ENTRY_FILE_MANAGEMENT;

import java.io.*;
import java.util.ArrayList;

/**
 * The class EntryFileManager is used to write and read Entries from a file.
 * @author Δημήτρης Δήμος
 */
public class EntryFileManager {
    private static File savesFile = new File("src/LOGIC/ENTRY_FILE_MANAGEMENT/saves");

    /**
     * Empty constructor.
     */
    public EntryFileManager(){ }

    /**
     * this method writes an Entry object into the file.
     * @param anEntry is the Entry object being written.
     */
    public void addEntry(Entry anEntry) {
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savesFile)))) {
//            outputStream.writeObject(anEntry);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ArrayList<Entry> allEntries = getAllEntries();
        allEntries.add(anEntry);
        updateEntries(allEntries);
    }

    /**
     * This method is used to traverse the file and read all the entries
     * @return an ArrayList<Entry> containing all the Entry objects in the File.
     */
    public ArrayList<Entry> getAllEntries() {
        ArrayList<Entry> entries = new ArrayList<>();
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(savesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream inputStream = new ObjectInputStream((new BufferedInputStream(fin)))){
            boolean eof = false;
            while (!eof) {
                try {
                    entries.add( (Entry) (inputStream.readObject()) );
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                catch (EOFException e) {
                    eof = true;
                }
            }
        } catch (EOFException e) {
            return entries;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }

    /**
     * This method searches for a given Entry object in the file based on the String field name. If it exists, the Entry object is returned.
     * If that is not the case, a new Entry object is created and returned.
     *
     * @param name the String that contains the name of the Entry.
     * @return the Entry.
     */
    public Entry getEntry(String name){
        ArrayList<Entry> allEntries = getAllEntries();
        Entry entry;
        for (Entry allEntry : allEntries) {
            if (name.equals(allEntry.getName())) {
                entry = allEntry;
                return entry;
            }
        }
        entry = new Entry(name);
        return entry;
    }

    /**
     * Updates all the old Entries in the file with the new given ones.
     * @param newEntries is an ArrayList<Entry> containing the new Entries.
     */
    public void updateEntries(ArrayList<Entry> newEntries) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savesFile)))) {
            for (Entry newEntry : newEntries) {
                outputStream.writeObject(newEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method searches if the given Entry exists in the file based on the given name. If that it the case it
     * updates the Entry with the new Entry. If the given Entry does not exist in the file, it adds it as a new one.
     * @param entry is the given Entry.
     */
    public void updateEntry(Entry entry) {
        ArrayList<Entry> allEntries = getAllEntries();

        for (int i = 0; i < allEntries.size(); i++) {
            if (allEntries.get(i).getName().equals(entry.getName())){
                allEntries.remove(i);
                allEntries.add(i, entry);
                updateEntries(allEntries);
                return;
            }
        }
        addEntry(entry);
    }

    public void emptyFile() {
        ArrayList<Entry> emptyEntries = new ArrayList<>();
        updateEntries(emptyEntries);
    }
}
