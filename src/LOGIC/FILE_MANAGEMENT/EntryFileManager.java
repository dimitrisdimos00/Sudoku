package LOGIC.FILE_MANAGEMENT;

import java.io.*;
import java.util.ArrayList;

public class EntryFileManager {
    private static File savesFile = new File("src/LOGIC/FILE_MANAGEMENT/saves");
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
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
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

    public void emptyEntries() {
        ArrayList<Entry> noEntries = new ArrayList<>();
        updateEntries(noEntries);
    }
}
