package GUI.SudokuFrame;

import GUI.AllOfListeners.CheckButtonActionListener;
import GUI.AllTheMenus.JTextFieldLimit;
import GUI.AllTheMenus.SecondMenu;

import javax.swing.*;
import java.awt.*;

public class OriginalSudokuFrame extends JFrame{

    private int[] numbers = null;
    private char[] letters = null;

    private String nameOfGame;
    private int numOfRows;
    private int numOfColumns;
    private String ButtonName;

    private JPanel firstPanel;
    private JTextField[][] theField;

    private JButton CheckButton;

    //-------------------------------------------------------------------------------------------------

    public JTextField[][] getTheField() {
        return theField;
    }
    public void setTheField(JTextField[][] theField) {
        this.theField = theField;
    }

    public int getNumOfRows() {
        return numOfRows;
    }
    public void setNumOfRows(int numOfRows) {
        this.numOfRows = numOfRows;
    }
    public int getNumOfColumns() {
        return numOfColumns;
    }
    public void setNumOfColumns(int numOfColumns) {
        this.numOfColumns = numOfColumns;
    }

    public int[] getNumbers() {
        return numbers;
    }
    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }
    public char[] getLetters() {
        return letters;
    }
    public void setLetters(char[] letters) {
        this.letters = letters;
    }

    //--------------------------------------------------------------------------------------------------

    public OriginalSudokuFrame(SecondMenu aSecondMenu, int numOfRows, int numOfColumns) {

        if (!aSecondMenu.getEpilogiKillerSudoku().isSelected() && aSecondMenu.getEpilogiArithmon().isSelected())
            numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9};
        if (!aSecondMenu.getEpilogiKillerSudoku().isSelected() && aSecondMenu.getEpilogiGrammaton().isSelected())
            letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected() && aSecondMenu.getEpilogiArithmon().isSelected())
            numbers = new int[]{1, 2, 3, 4};
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected() && aSecondMenu.getEpilogiGrammaton().isSelected())
            letters = new char[]{'A', 'B', 'C', 'D'};

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected())
            this.nameOfGame = "Original Sudoku";
        else if (aSecondMenu.getEpilogiKillerSudoku().isSelected())
            this.nameOfGame = "Killer Sudoku";
        else if (aSecondMenu.getEpilogiDuiDoku().isSelected())
            this.nameOfGame = "Duidoku";

        String ButtonName = aSecondMenu.isFromGreekMenu() ? "Έλεγχος" : "Check";

        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.ButtonName = ButtonName;

        this.makeFrame();
    }

    private void makeFrame() {
        setTitle(nameOfGame);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPanel = new JPanel(new GridLayout(numOfRows,numOfColumns));
        theField = new JTextField[numOfRows][numOfColumns];
        for (int i=0; i<numOfRows ;i++) {
            for (int j=0; j<numOfColumns ;j++) {
                theField[i][j] = new JTextField("");
                theField[i][j].setHorizontalAlignment(JTextField.CENTER);
                theField[i][j].setFont(new Font("Verdana", Font.BOLD,20));
                theField[i][j].setDocument(new JTextFieldLimit(1));
                firstPanel.add(theField[i][j]);
            }
        }

        CheckButtonActionListener aCheckButtonActionListener = new CheckButtonActionListener(this);
        CheckButton = new JButton(ButtonName);
        CheckButton.addActionListener(aCheckButtonActionListener);

        add(firstPanel);
        add(CheckButton, BorderLayout.PAGE_END);
        pack();

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
