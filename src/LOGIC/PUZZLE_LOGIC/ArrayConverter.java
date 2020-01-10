package LOGIC.PUZZLE_LOGIC;

/**
 * The class ArrayConverter contains some basic array functions used by the classes Logic, Sudoku, KillerSudoku and Duidoku
 * @author Δημήτρης Δήμος
 */
public class ArrayConverter {
    private int n;

    /**
     * Constructor
     * @param n is the number of rows in the sudoku
     */
    public ArrayConverter(int n){
        this.n = n;
    }

    /**
     * This method is used in order for an int to be converted to a char from 'A' to 'I'.
     * It is used in wordoku.
     * @param i must be from 0 to 8
     * @return the char that is associated with i
     */
    public char intToChar(int i){
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

    /**
     * This method is used in order to make a 1D int[n * n] array to a 2D int[n][n] one.
     * @param array is the original 1D array
     * @return the final 2D int array
     */
    public int[][] arrayToIntMatrix(int[] array) {
        int[][] matrix = new int[n][n];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = array[counter];
                counter++;
            }
        }

        return matrix;
    }

    /**
     * This method is used in order to make a 1D int[n * n] array to a 2D char[n][n] one. Either with characters from '1'
     * to '9' if isNumerical == true or with characters from 'A' to 'I' if isNumerical is false.
     * @param array the original 1D array
     * @param isNumerical true for numerical characters, false for alphabetical ones.
     * @return the final 2D char array.
     */
    public char[][] arrayToCharMatrix(int[] array, boolean isNumerical) {
        char[][] matrix = new char[n][n];
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isNumerical) {
                    matrix[i][j] = (char) (array[counter] + '0');
                }
                else {
                    matrix[i][j] = intToChar(array[counter]);
                }
                counter++;
            }
        }

        return matrix;
    }

    /**
     * This method fills a 2D char[n][n] array with the character '0'.
     * @return the final 2D char array.
     */
    public char[][] matrixToZeros(){
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix [i][j]= '0';
            }
        }
        return matrix;
    }
}
