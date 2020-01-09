package LOGIC;

public class ArrayConverter {
    private int n;
    public ArrayConverter(int n){
        this.n = n;
    }

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
