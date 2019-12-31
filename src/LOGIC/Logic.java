package LOGIC;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private int[][] A;
    private char[][] sudoku;
    private int n;
    private boolean numerical;
    private SudokuFrame aSudokuFrame;

    //------------------------------------------------------------------------------------------------

    public int[][] getA() {
        return A;
    }
    public char[][] getSudoku() {
        return sudoku;
    }
    public int getN() {
        return n;
    }
    public boolean isNumerical() {
        return numerical;
    }

    public void setA(int[][] a) {
        A = a;
    }
    public void setSudoku(char[][] sudoku) {
        this.sudoku = sudoku;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void setNumerical(boolean numerical) {
        this.numerical = numerical;
    }

    //------------------------------------------------------------------------------------------------

    private void initializeSudoku(int selection){
        sudoku = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (selection == 1 && numerical) {
                    sudoku[i][j] = (char)(A[i][j] + '0');
                }
                else if (selection == 1) {
                    sudoku[i][j] = intToChar(A[i][j]);
                }
                else {
                    sudoku[i][j] = '0';
                }
            }
        }
    }

    public Logic(int sudoku_selection, boolean isNumerical, SudokuFrame aSudokuFrame){//sudoku_selection = {1(classic), 2(killer), 3(duidoku)}

        this.aSudokuFrame = aSudokuFrame;

        numerical = isNumerical;

        if (sudoku_selection == 1 || sudoku_selection == 2){
            n = 9;
            ReadFile readFile = new ReadFile(sudoku_selection);
            A = readFile.getRandomPuzzle();
        }
        else{
            n = 4;
            A = new int[n][n];
        }
        initializeSudoku(sudoku_selection);
    }
    private char intToChar(int i){
        if (i == 0) { return '0'; }
        else if (i == 1){ return 'A'; }
        else if (i == 2){ return 'B'; }
        else if (i == 3){ return 'C'; }
        else if (i == 4){ return 'D'; }
        else if (i == 5){ return 'E'; }
        else if (i == 6){ return 'F'; }
        else if (i == 7){ return 'G'; }
        else if (i == 8){ return 'H'; }
        return 'I';
    }

    public boolean isElementInRow(int row, char el){        // 0 =< row < n
        for (int j = 0; j <= n - 1; j++) {
            if(sudoku[row][j] == el){
                return true;
            }
        }
        return false;
    }   //ok

    public boolean isElementInColumn(int col, char el){     // 0 =< col < n
        for (int i = 0; i <= n - 1; i++) {
            if(sudoku[i][col] == el){
                return true;
            }
        }
        return false;
    }   //ok

    public boolean isElementInBox(int row, int col, char el){   // 0 =< row < n && 0 =< col < n
        int sqrtn = (int)Math.sqrt(n);
        int row_start = row / sqrtn * sqrtn;
        int col_start = col/ sqrtn * sqrtn;

        for (int i = row_start; i <= row_start + sqrtn - 1; i++) {
            for (int j = col_start; j <= col_start + sqrtn - 1; j++) {
                if (sudoku[i][j] == el) {
                    return true;
                }
            }
        }
        return false;

    }   //ok

    public boolean hasWon(){
        boolean hasZeros = false;
        for (int i = 0; i <= n - 1;i++){
            for (int j = 0; j <= n - 1;j++){
                if (sudoku[i][j] == '0') {
                    hasZeros = true;
                    break;
                }
            }
        }
        return !hasZeros;
    }

    public boolean insertElement(int row, int col, char el){ //  0=< row < n, 0=< col < n, choice = N or choice = L
        boolean condition;
        if (numerical){
            condition = el >= '1' && el <= (char)(n + '0');
        }
        else {
            condition = 'A' <= el && el <= 'I';
        }

        if(condition){
            boolean canBePlaced = !isElementInRow(row, el) && !isElementInColumn(col, el) && !isElementInBox(row, col, el);
            if(canBePlaced){
                sudoku[row][col] = el;
                return true;
            }
        }
        return false;
    }

    public ArrayList<Character> availableElementsForGivenCoordinates(int row, int col){
        ArrayList<Character> availableElements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (numerical) {
                if (insertElement(row, col, (char)(i + '0'))){
                    availableElements.add((char)(i + '0'));
                }
            }
            else {
                if (insertElement(row, col, intToChar(i))){
                    availableElements.add(intToChar(i));
                }
            }
        }
        return availableElements;
    }

    public void computerPlays(){
        Random random = new Random();
        int randomRow = random.nextInt(n);
        int randomColumn = random.nextInt(n);
        char randomElement;
        if (numerical) {
            randomElement = (char)(random.nextInt(n) + 1 + '0');
        }
        else {
            randomElement = intToChar(random.nextInt(n) + 1);
        }
        while (aSudokuFrame.getTheField()[randomRow][randomColumn].getBackground().equals(Color.black)||sudoku[randomRow][randomColumn] != '0' || !insertElement(randomRow, randomColumn, randomElement)){
            randomRow = random.nextInt(n);
            randomColumn = random.nextInt(n);
            if (numerical) {
                randomElement = (char) (random.nextInt(n) + '0');
            }
            else {
                randomElement = intToChar(random.nextInt(n));
            }
        }
    }

    public void showArray(){ //ok
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(sudoku[i][j] + "  ");
            }
            System.out.println('\n');
        }
    }

    public boolean Input(boolean help){
        Scanner scanner = new Scanner(System.in);

        System.out.print("row: ");
        int row = scanner.nextInt();
        System.out.print("col: ");
        int column = scanner.nextInt();
        if (help) {
            System.out.println("Available elements: " + availableElementsForGivenCoordinates(row, column));     // help
        }
        System.out.print("element: ");
        char element = scanner.next().charAt(0);
        return insertElement(row, column, element);
    }
}
