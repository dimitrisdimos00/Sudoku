package LOGIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class ReadFile {
    private File puzzlesFile;
    private static int n = 9;
    private static int number_of_puzzles = 10;

//-----------------------------------------------------------

    public void setPuzzlesFile(File puzzlesFile) {
        this.puzzlesFile = puzzlesFile;
    }

    public File getPuzzlesFile() {
        return puzzlesFile;
    }

//-----------------------------------------------------------

    public ReadFile (int selection){
        if (selection == 1){
            setPuzzlesFile(new File("src/LOGIC/classicpuzzles"));
        }
        else {
            setPuzzlesFile(new File("src/LOGIC/killerpuzzles"));
        }
    }

    public ArrayList<int[]> readPuzzlesFromFile(){
        ArrayList<int[]> arrayPuzzles = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(puzzlesFile);
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
        catch (FileNotFoundException e){
            System.out.println( "Δεν βρέθηκε ο φάκελος!");
            return null;
        }
    }

    public int[][] getRandomPuzzle(){
        Random random = new Random();
        return arrayToMatrix(readPuzzlesFromFile().get(random.nextInt(number_of_puzzles)));
    }

    private int[][] arrayToMatrix(int[] array) {
        int[][] matrix = new int[n][n];
        int counter = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                matrix[j][k] = array[counter];
                counter++;
            }
        }
        return matrix;
    }
}
