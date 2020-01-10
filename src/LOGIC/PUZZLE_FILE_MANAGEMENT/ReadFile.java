package LOGIC.PUZZLE_FILE_MANAGEMENT;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is used to read the puzzles from the file and select a random one based on an ArrayList that contains
 * the possible selections
 * @author Δημήτρης Δήμος
 */
public class ReadFile {
    private File puzzlesFile;
    private static int n = 9;
    private static int number_of_puzzles = 10;
    private int randomPuzzleIndex;

//-----------------------------------------------------------

    public void setPuzzlesFile(File puzzlesFile) {
        this.puzzlesFile = puzzlesFile;
    }

    public void setRandomPuzzleIndex(int randomPuzzleIndex) { this.randomPuzzleIndex = randomPuzzleIndex; }

    public File getPuzzlesFile() {
        return puzzlesFile;
    }

    public int getRandomPuzzleIndex() { return randomPuzzleIndex; }

    //-----------------------------------------------------------

    /**
     * The constructor of the class ReadFile sets the path of the file with the puzzles based on whether someone plays
     * classic sudoku or killer sudoku.
     * @param selection is 1 for classic sudoku puzzles and 2 for killer sudoku puzzles.
     */
    public ReadFile (int selection){
        if (selection == 1){
            setPuzzlesFile(new File("src/LOGIC/PUZZLE_FILE_MANAGEMENT/classicpuzzles"));
        }
        else {
            setPuzzlesFile(new File("src/LOGIC/PUZZLE_FILE_MANAGEMENT/killerpuzzles"));
        }
    }

    /**
     * This method opens the puzzles file and reads it using a Scanner object. In the file, the end of the puzzle is
     * marked by -1. Each puzzle is stored in an int[n * n] array. When -1 is reached a new int array is created.
     * These arrays are stored in an ArrayList<int[]> object that is then returned.
     * @return ArrayList<int[]> containing all the puzzles.
     * @throws FileNotFoundException if the file is not found.
     */
    private ArrayList<int[]> readPuzzlesFromFile() throws FileNotFoundException {
        ArrayList<int[]> arrayPuzzles = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(puzzlesFile)))) {
            for (int i = 0; i < number_of_puzzles; i++) {
                int[] elements = new int[n * n];

                int counter = 0;
                int nextInt = scanner.nextInt();

                while (nextInt != -1) {
                    elements[counter] = nextInt;
                    counter++;
                    nextInt = scanner.nextInt();
                }
                arrayPuzzles.add(elements);
            }

            return arrayPuzzles;
        }
    }

    /**
     * Takes an ArrayList with wanted puzzles (from 0 to 9) and selects a random one of them. The method also stores
     * the random's puzzle index in ReadFile's randomPuzzleIndex private field. If the parameter has zero size, null is
     * returned and randomPuzzleIndex is set to -1.
     * @param wantedPuzzles contains an ArrayList<Integer> with the wanted puzzles indexes.
     * @return an int[n * n] array containing the puzzle.
     * @throws FileNotFoundException because the method readPuzzlesFromFile is called.
     */
    public int[] getRandomPuzzle(ArrayList<Integer> wantedPuzzles) throws FileNotFoundException {
        Random random = new Random();
        if (wantedPuzzles.size() == 0){
            randomPuzzleIndex = -1;
            return null;
        }
        randomPuzzleIndex = random.nextInt(wantedPuzzles.size());
        return readPuzzlesFromFile().get(wantedPuzzles.get(randomPuzzleIndex));
    }
}
