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
        selection = sudoku_selection;
        File file;
        if (sudoku_selection == 1){
            file = new File("src/LOGIC/classicpuzzles");
            n = 9;
        }
        else if(sudoku_selection == 2){
            file = new File("src/LOGIC/killerpuzzles");
            n = 9;
        }
        else{
            file = new File("src/LOGIC/duidokupuzzles");
            n = 4;
        }
        puzzlesFile = file;
        A = new int[n][n];
        arrayInitialization();
    }

    private void arrayInitialization(){
        Integer[] intElements = GetRandomPuzzle();

        if (intElements == null) {
            System.out.println("intElements = null!");
            return;
        }
        int counter = 0;
        int sizeOfArray = 0;
        sizeOfArray = intElements.length;
        for(int i = 0; i <= n - 1; i ++){
            for(int j = 0; j <= n - 1; j++){
                if (counter < sizeOfArray) {
                    A[i][j] = intElements[counter];
                    counter ++;
                }
            }
        }
    }

    private ArrayList<String> readPuzzlesFromFile(){
        ArrayList<String> StringElements= new ArrayList<>();

        try{
            Scanner scanner = new Scanner(puzzlesFile);
            while (scanner.hasNext()) {
                StringElements.add(scanner.next());
            }
            return StringElements;
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

    private Integer[] GetRandomPuzzle(){
        ArrayList<String> StringElements= readPuzzlesFromFile();
        Random rand = new Random();

        int size = 0;
        if (StringElements == null) {
            System.out.println("StringELements == null!");
            return null;
        }
        size = StringElements.size();
        int randomInt = rand.nextInt(size);
        char[] characterArray = StringElements.get(randomInt).toCharArray();
        size = characterArray.length;
        Integer[] integerArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            integerArray[i] = Character.getNumericValue(characterArray[i]);
        }
        return integerArray;

    }

    private boolean elementInRow(int row, int el){ // 0=< row_start, row_end <=n  0=< col_start, col_end <=n
        for (int j = 0; j <= n - 1; j++) {
            if(A[row][j] == el){
                return true;
            }
        }
        return false;
    } //ok

    private boolean elementInColumn(int col, int el){ // 0=< row_start, row_end <=n  0=< col_start, col_end <=n
        for (int i = 0; i <= n - 1; i++) {
            if(A[i][col] == el){
                return true;
            }
        }
        return false;
    } //ok

    private boolean findAndCheckBox(int row, int col, int el){
        int row_start = 0, col_start = 0;

        if (n == 9) {
            row_start = row / 3 * 3;
            col_start = col/ 3 * 3;
            return elementInBox(row_start, row_start + 2, col_start, col_start + 2, el);
        }
        else {
            row_start = row / 2 * 2;
            col_start = col/ 2 * 2;
            return elementInBox(row_start, row_start + 1, col_start, col_start + 1, el);
        }
    }

    private boolean elementInBox(int row_start, int row_end, int col_start, int col_end, int el){ // 0=< row_start, row_end < n  0=< col_start, col_end < n
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
            boolean canBePlaced = true;
            canBePlaced = !elementInColumn(col, el);

            if (!canBePlaced) {
                canBePlaced = !elementInRow(row, el);
            }

            if(!canBePlaced){
                canBePlaced = !findAndCheckBox(row, col, el);
            }

            if(!canBePlaced){
                A[row][col] = el;
                return true;
            }
            else{
                System.out.println("Ayto to stoixeio den mporei na mpei se ayth th thesi!");
                return false;
            }
        }
    }

    public void showArray(){ //ok
        for (int i = 0; i <= n - 1;i++){
            for (int j = 0; j <= n - 1;j++){
                System.out.print(A[i][j] + " ");
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
