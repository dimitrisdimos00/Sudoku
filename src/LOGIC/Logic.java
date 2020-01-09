package LOGIC;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private int n;
    private char[][] sudoku;
    private boolean isNumerical;
    private ArrayConverter arrayConverter;
    private SudokuFrame aSudokuFrame;

    //------------------------------------------------------------------------------------------------
    public int getN() {
        return n;
    }
    public char[][] getSudoku() {
        return sudoku;
    }
    public boolean isNumerical() {
        return isNumerical;
    }
    public ArrayConverter getArrayConverter() { return arrayConverter; }
    public SudokuFrame getaSudokuFrame() {
        return aSudokuFrame;
    }


    public void setN(int n) {
        this.n = n;
    }
    public void setSudoku(char[][] sudoku) {
        this.sudoku = sudoku;
    }
    public void setNumerical(boolean numerical) { isNumerical = numerical; }
    public void setArrayConverter(ArrayConverter arrayConverter) { this.arrayConverter = arrayConverter; }
    public void setaSudokuFrame(SudokuFrame aSudokuFrame) {
        this.aSudokuFrame = aSudokuFrame;
    }
    //------------------------------------------------------------------------------------------------

    public Logic() {
    }

    public Logic(int sudoku_selection, boolean isNumerical, SudokuFrame aSudokuFrame){ //sudoku_selection = {1(classic), 2(killer), 3(duidoku)}
        this.isNumerical = isNumerical;
        this.aSudokuFrame = aSudokuFrame;
        if (sudoku_selection == 1 || sudoku_selection == 2){
            n = 9;
        }
        else{
            n = 4;
        }
        arrayConverter = new ArrayConverter(n);
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
        if (isNumerical){
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
        ArrayConverter arrayConverter = new ArrayConverter(n);

        for (int i = 1; i <= n; i++) {
            if (isNumerical) {
                if (insertElement(row, col, (char)(i + '0'))){
                    availableElements.add((char)(i + '0'));
                }
            }
            else {
                if (insertElement(row, col, arrayConverter.intToChar(i))){
                    availableElements.add(arrayConverter.intToChar(i));
                }
            }
        }
        return availableElements;
    }
}
