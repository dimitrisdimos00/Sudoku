package LOGIC;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private int[][] A;
    private int n;
    private File puzzlesFile;
    private int selection;

    //------------------------------------------------------------------------------------------------

    public int[][] getA() {
        return A;
    }
    public int getN() {
        return n;
    }
    public File getPuzzlesFile() {
        return puzzlesFile;
    }
    public int getSelection() {
        return selection;
    }


    public void setA(int[][] a) {
        A = a;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void setPuzzlesFile(File puzzlesFile) {
        this.puzzlesFile = puzzlesFile;
    }
    public void setSelection(int selection) {
        this.selection = selection;
    }


    //------------------------------------------------------------------------------------------------

    public Logic(int sudoku_selection){//sudoku_selection = {1(classic), 2(killer), 3(duidoku)}
        setSelection(sudoku_selection);
        if (getSelection() == 1){
            setPuzzlesFile(new File("src/LOGIC/classicpuzzles"));
            setN(9);
        }
        else if(getSelection() == 2){
            setPuzzlesFile(new File("src/LOGIC/killerpuzzles"));
            setN(9);
        }
        else{
            setN(4);
        }
        A = new int[n][n];
        setA(GetRandomPuzzle());
    }

    private ArrayList<int[][]> readPuzzlesFromFile(){
        ArrayList<int[][]> puzzles = new ArrayList<>();

        try{
            Scanner scanner = new Scanner(puzzlesFile);
            for (int i = 0; i < 10; i++) { // 10 puzzles
                int[][] puzzle = new int[n][n];
                int[] elements = new int[n*n];

                int counter = 0;
                int nextInt = scanner.nextInt();

                while (nextInt != -1) {
                    elements[counter] = nextInt;
                    counter++;
                    nextInt = scanner.nextInt();
                }

                counter = 0;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        puzzle[j][k] = elements[counter];
                        counter++;
                    }
                }
                puzzles.add(puzzle);
            }

            return puzzles;
        }
        catch (FileNotFoundException e){
            System.out.println( "Δεν βρέθηκε ο φάκελος!");
            return null;
        }
        catch (Exception ex){
            System.err.println(ex);
            return null;
        }
    }

    private int[][] GetRandomPuzzle(){
        ArrayList<int[][]> puzzles = readPuzzlesFromFile();

        if (puzzles == null) {
            System.out.println("puzzles == null!");
            return null;
        }
        Random rand = new Random();

        int randomInt = rand.nextInt(10);

        return puzzles.get(randomInt);
    }

    public boolean isElementInRow(int row, int el){ // 0=< row_start, row_end <=n  0=< col_start, col_end <=n
        for (int j = 0; j <= n - 1; j++) {
            if(A[row][j] == el){
                return true;
            }
        }
        return false;
    } //ok

    public boolean isElementInColumn(int col, int el){ // 0=< row_start, row_end <=n  0=< col_start, col_end <=n
        for (int i = 0; i <= n - 1; i++) {
            if(A[i][col] == el){
                return true;
            }
        }
        return false;
    } //ok

    public boolean isElementInBox(int row, int col, int el){
        int row_start, col_start;

        if (n == 9) {
            row_start = row / 3 * 3;
            col_start = col/ 3 * 3;
            return isElementInGivenArea(row_start, row_start + 2, col_start, col_start + 2, el);
        }
        else {
            row_start = row / 2 * 2;
            col_start = col/ 2 * 2;
            return isElementInGivenArea(row_start, row_start + 1, col_start, col_start + 1, el);
        }
    }

    private boolean isElementInGivenArea(int row_start, int row_end, int col_start, int col_end, int el){ // 0=< row_start, row_end < n  0=< col_start, col_end < n
        for (int i = row_start; i <= row_end; i++) {
            for (int j = col_start; j <= col_end; j++) {
                if (A[i][j] == el) { return true; }
            }
        }
        return false;
    }

    public boolean hasWon(){
        boolean hasZeros = false;
        for (int i = 0; i <= n - 1;i++){
            for (int j = 0; j <= n - 1;j++){
                if (A[i][j] == 0) {
                    hasZeros = true;
                    break;
                }
            }
        }
        return !hasZeros;
    }

    public boolean insertElement(int el, int row, int col){ //  0=< row <=n  0=< col <=n
        if(! (row >= 0 && row <= n && col >= 0 && col <= n)) {
            System.out.println("λάθος συντεταγμένες");
            return false;
        }
        else if(!(el >= 1 && el <= 9)){
            System.out.println("Λάθος στοιχείο!");
            return false;
        }
        else{
            boolean canBePlaced = !isElementInRow(row, el) && !isElementInColumn(col, el) && !isElementInBox(row, col, el);

            if(canBePlaced){
                A[row][col] = el;
                return true;
            }
            else{
                System.out.println("Αυτό το στοιχείο δεν μπορεί να μπεί σε αυτή τη θέση!");
                return false;
            }
        }
    }

    public ArrayList<Integer> availableNumbersForGivenCoordinates(int row, int col){
        ArrayList<Integer> availableNumbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (insertElement(i, row, col)){
                availableNumbers.add(i);
            }
        }
        return availableNumbers;
    }

    public void showArray(){ //ok
        for (int i = 0; i <= n - 1;i++){
            for (int j = 0; j <= n - 1;j++){
                System.out.print(A[i][j] + "  ");
            }
            System.out.println('\n');
        }
    }

    public int[] Input(){
        int []answer = new int[3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("element: ");
        answer[0] = scanner.nextInt();
        System.out.print("row: ");
        answer[1] = scanner.nextInt();
        System.out.print("col: ");
        answer[2] = scanner.nextInt();
        return answer;
    }
}
