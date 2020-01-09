package LOGIC.PUZZLE_FILE_MANAGEMENT;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ReadFile {
    private File puzzlesFile;
    private static int n = 9;
    private static int number_of_puzzles = 10;
    private int randomPuzzleIndex;

//-----------------------------------------------------------

    public void setPuzzlesFile(File puzzlesFile) {
        this.puzzlesFile = puzzlesFile;
    }

    public void setRandomPuzzle(int randomPuzzleIndex) { this.randomPuzzleIndex = randomPuzzleIndex; }

    public File getPuzzlesFile() {
        return puzzlesFile;
    }

    public int getRandomPuzzleIndex() { return randomPuzzleIndex; }

    //-----------------------------------------------------------

    public ReadFile (int selection){
        if (selection == 1){
            setPuzzlesFile(new File("src/LOGIC/PUZZLE_FILE_MANAGEMENT/classicpuzzles"));
        }
        else {
            setPuzzlesFile(new File("src/LOGIC/PUZZLE_FILE_MANAGEMENT/killerpuzzles"));
        }
    }

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

    public int[] getRandomPuzzle(ArrayList<Integer> wantedPuzzles) throws FileNotFoundException {
        Random random = new Random();
        randomPuzzleIndex = random.nextInt(wantedPuzzles.size());
        return readPuzzlesFromFile().get(wantedPuzzles.get(randomPuzzleIndex));
    }
}
