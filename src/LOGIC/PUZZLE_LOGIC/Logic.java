package LOGIC.PUZZLE_LOGIC;

/**
 * The Logic class contains some boolean functions for checking rows, columns, and sudoku-boxes for a given element as well
 * as when a sudoku puzzle is finished. The class also inserts elements in the puzzle if this is possible. The puzzle is
 * implemented using a 2d char array called "sudoku".
 *
 * @author Δημήτρης Δήμος
 */
public class Logic {
    private int n;
    private char[][] sudoku;
    private boolean isNumerical;
    private ArrayConverter arrayConverter;

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


    public void setN(int n) {
        this.n = n;
    }
    public void setSudoku(char[][] sudoku) {
        this.sudoku = sudoku;
    }
    public void setNumerical(boolean numerical) { isNumerical = numerical; }
    public void setArrayConverter(ArrayConverter arrayConverter) { this.arrayConverter = arrayConverter; }
    //------------------------------------------------------------------------------------------------

    public Logic() {
    }

    /**
     * The constructor of Logic takes into account 3 possible selections (classic sudoku, killer sudoku and duidoku)
     * as well as if they are numerical (elements are '1'-'9'), or wordokus (elements are 'A'-'I'). For classic and killer sudokus
     * the default number of rows and columns (= n) is 9, while for duidoku it is 4. The sudokus are implemented with a char[n][n]
     * array/ matrix. The Array converter object is used for some array conversions.
     *
     * @param sudoku_selection 1(classic), 2(killer), 3(duidoku)
     * @param isNumerical true for numerical, false for wordoku
     */
    public Logic(int sudoku_selection, boolean isNumerical){
        this.isNumerical = isNumerical;
        if (sudoku_selection == 1 || sudoku_selection == 2){
            n = 9;
        }
        else{
            n = 4;
        }
        arrayConverter = new ArrayConverter(n);
    }

    /**
     * Checks if the given element is in given row
     * @param row The given row. 0 =< row < n
     * @param el The given element. el =  '1'-'9' if isNumerical or el = 'A'-'I' if !isNumerical
     * @return true if the element exists in given row and false otherwise
     */
    public boolean isElementInRow(int row, char el){
        for (int j = 0; j <= n - 1; j++) {
            if(sudoku[row][j] == el){
                return true;
            }
        }
        return false;
    }   //ok

    /**
     * Checks if the given element is in given column
     * @param col The given column. 0 =< col < n
     * @param el The given element. el =  '1'-'9' if isNumerical or el = 'A'-'I' if !isNumerical
     * @return true if the element exists in given column and false otherwise
     */
    public boolean isElementInColumn(int col, char el){     // 0 =< col < n
        for (int i = 0; i <= n - 1; i++) {
            if(sudoku[i][col] == el){
                return true;
            }
        }
        return false;
    }   //ok

    /**
     * Checks if the given element exists in the 3x3 (for n = 9) or 2x2 (for n = 4) sudoku - box
     * in which the given row and column point to. For example if row = 0, column = 0, and n = 9, the box to be checked is
     * the box from row 0 to 2 and from column 0 to column 2.
     * @param row The given row. 0 =< row < n
     * @param col The given column. 0 =< col < n
     * @param el The given element. el =  '1'-'9' if isNumerical or el = 'A'-'I' if !isNumerical
     * @return true if the element exists in box and false otherwise
     */
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

    /**
     * Checks if the puzzle is solved. For a sudoku to be solved, there should be no 0 cells, given that every
     * given element is inserted only if it does not exist in given row, column and 3x3 or 2x2 box.
     * @return true if there are no '0' in the matrix, false otherwise
     */
    public boolean hasWon(){
        boolean hasZeros = false;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (sudoku[i][j] == '0') {
                    hasZeros = true;
                    break;
                }
            }
        }
        return !hasZeros;
    }

    /**
     * Calls the methods isElementInRow, isElementInColumn, isElementInBox, for given row and column, and inserts the element
     * to the 2d array if all three are false.
     * @param row The given row. 0 =< row < n
     * @param col The given column. 0 =< col < n
     * @param el The given element. el =  '1'-'9' if isNumerical or el = 'A'-'I' if !isNumerical
     * @return true if given element is inserted, false otherwise
     */
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
}
