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
    private int sds;
    File puzzlesFile;

    public Logic(int n, int sudoku_selection){ // n = 4 or n = 9, sudoku_selection = {1(classic), 2(killer), 3(duidoku)}
        this.n = n;
        sds = sudoku_selection;
        A = new int[n][n];
        arrayInitialization();

        if (sds == 1){
            File puzzlesFile = new File("classicpuzzles");
        }
        else if(sds == 2){
            File puzzlesFile = new File("killerpuzzles");
        }
        else{
            File puzzlesFile = new File("duidokupuzzles");
        }
    }

    private void arrayInitialization(){

        Integer[] intElements = readPuzzleFromFile();
        int counter = 0;
        int sizeOfArray = intElements.length;
        for(int i = 0; i <= n - 1; i ++){
            for(int j = 0; j <= n - 1; j++){
                if (counter < sizeOfArray) {
                    A[i][j] = intElements[counter];
                    counter ++;
                }
            }
        }
    }

    private Integer[] readPuzzleFromFile(){
        ArrayList<String> StringElements= new ArrayList<>();

        Random rand = new Random();

        try{
            Scanner scanner = new Scanner(puzzlesFile);
            while (scanner.hasNext()) {
                StringElements.add(scanner.next());
            }

            int size = StringElements.size();
            int randomInt = rand.nextInt(size);
            char[] characterArray = StringElements.get(randomInt).toCharArray();

            size = characterArray.length;
            Integer[] integerArray = new Integer[size];
            for (int i = 0; i < size; i++) {
                integerArray[i] = Character.getNumericValue(characterArray[i]);
            }
            return integerArray;
        }
        catch (FileNotFoundException e){
            System.out.println( "Δεν βρέθηκε ο φάκελος!");
            return null;
        }

    } // ok

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
        if(row <= 2){
            if(col <= 2){
                return elementInBox(0,2,0,2, el);
            }
            else if(col <= 5){
                return elementInBox(0, 2, 3,5, el);
            }
            else {
                return elementInBox(0, 2, 6,8, el);
            }
        }
        else if(row <= 5){
            if(col <= 2){
                return elementInBox(3,5,0,2, el);
            }
            else if(col <= 5){
                return elementInBox(3,5,3,5, el);
            }
            else {
                return elementInBox(3,5,6,8, el);
            }
        }
        else{
            if(col <= 2){
                return elementInBox(6,8,0,2, el);
            }
            else if(col <= 5){
                return elementInBox(6,8,3,5, el);
            }
            else {
                return elementInBox(6,8,6,8, el);
            }
        }
    }

    private boolean elementInBox(int row_start, int row_end, int col_start, int col_end, int el){ // 0=< row_start, row_end <=n  0=< col_start, col_end <=n
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
                if(A[i][j] == 0){
                    hasZeros = true;
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
