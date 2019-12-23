package GUI.SudokuFrame;

import javax.swing.*;

public class KillerSudokuFrame extends JFrame {

    private JTable theTable;

    public KillerSudokuFrame(int numOfRows, int numOfColumns) {
        makeFrame(numOfRows, numOfColumns);
    }

    private void makeFrame(int numOfRows, int numOfColumns) {
        setTitle("Killer Sudoku");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        theTable = new JTable(numOfRows, numOfColumns);
        theTable.setRowHeight(55);

        add(theTable);

        setSize(535,535);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new KillerSudokuFrame(9,9);
    }

}
