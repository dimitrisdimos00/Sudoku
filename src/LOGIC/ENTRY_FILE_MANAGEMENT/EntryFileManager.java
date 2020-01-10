package LOGIC.ENTRY_FILE_MANAGEMENT;

import java.io.*;
import java.util.ArrayList;

public class EntryFileManager {
    private static File savesFile = new File("src/LOGIC/ENTRY_FILE_MANAGEMENT/saves");
    public EntryFileManager(){ }

    public void addEntry(Entry anEntry) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savesFile)))) {
            outputStream.writeObject(anEntry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public void updateEntries(ArrayList<Entry> newEntries) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(savesFile)))) {
            for (Entry newEntry : newEntries) {
                outputStream.writeObject(newEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}
