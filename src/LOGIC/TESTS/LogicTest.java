package LOGIC.TESTS;

import LOGIC.PUZZLE_LOGIC.Logic;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest {

    @org.junit.jupiter.api.Test
    void isElementInRow() {
        Logic logic = new Logic(1, true);
        int n = logic.getN();
        char[][] charMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = '0';
            }
        }
        charMatrix[0][3] = '1';
        logic.setSudoku(charMatrix);
        assertTrue(logic.isElementInRow(0, '1'));
    }

    @org.junit.jupiter.api.Test
    void isElementInColumn() {
        Logic logic = new Logic(3, false);
        int n = logic.getN();
        char[][] charMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = '0';
            }
        }
        charMatrix[2][3] = 'A';
        logic.setSudoku(charMatrix);
        assertTrue(logic.isElementInColumn(3, 'A'));
    }

    @org.junit.jupiter.api.Test
    void isElementInBox() {
        Logic logic = new Logic(1, true);
        int n = logic.getN();
        char[][] charMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = '0';
            }
        }
        charMatrix[4][4] = '4';
        logic.setSudoku(charMatrix);
        assertTrue(logic.isElementInBox(4, 4,'4' ));
    }

    @org.junit.jupiter.api.Test
    void hasWon() {
        Logic logic = new Logic(1, true);
        int n = logic.getN();
        char[][] charMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = '1';
            }
        }
        logic.setSudoku(charMatrix);
        assertTrue(logic.hasWon());
    }

    @org.junit.jupiter.api.Test
    void insertElement() {
        Logic logic = new Logic(1, true);
        int n = logic.getN();
        char[][] charMatrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                charMatrix[i][j] = '0';
            }
        }
        logic.setSudoku(charMatrix);
        assertTrue(logic.insertElement(0,0,'1'));
    }
}