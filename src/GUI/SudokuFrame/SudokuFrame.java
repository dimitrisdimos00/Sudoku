package GUI.SudokuFrame;

import GUI.AllOfListeners.CheckButtonActionListener;
import GUI.AllTheMenus.JTextFieldLimit;
import GUI.AllTheMenus.SecondMenu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SudokuFrame extends JFrame{

    private int[] numbers = null;
    private char[] letters = null;

    private SecondMenu aSecondMenu;

    private String nameOfGame;
    private String borderName;
    private int numOfRows;
    private int numOfColumns;
    private String ButtonName;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JTextField[][] theField;

    private JLabel aLabel;
    private JTextField aTextField;

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

    public SudokuFrame(SecondMenu aSecondMenu, int numOfRows, int numOfColumns) {

        if (!aSecondMenu.getEpilogiDuiDoku().isSelected() && aSecondMenu.getEpilogiArithmon().isSelected())
            numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8 ,9};
        if (!aSecondMenu.getEpilogiDuiDoku().isSelected() && aSecondMenu.getEpilogiGrammaton().isSelected())
            letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        if (aSecondMenu.getEpilogiDuiDoku().isSelected() && aSecondMenu.getEpilogiArithmon().isSelected())
            numbers = new int[]{1, 2, 3, 4};
        if (aSecondMenu.getEpilogiDuiDoku().isSelected() && aSecondMenu.getEpilogiGrammaton().isSelected())
            letters = new char[]{'A', 'B', 'C', 'D'};

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected())
            this.nameOfGame = "Original Sudoku";
        else if (aSecondMenu.getEpilogiKillerSudoku().isSelected())
            this.nameOfGame = "Killer Sudoku";
        else if (aSecondMenu.getEpilogiDuiDoku().isSelected())
            this.nameOfGame = "Duidoku";

        this.ButtonName = aSecondMenu.isFromGreekMenu() ? "Έλεγχος" : " Check ";
        this.borderName = aSecondMenu.isFromGreekMenu() ? " Βοήθεια " : "Help" ;

        this.aSecondMenu = aSecondMenu;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;

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

        //-----------------------------------------------------------------------------------------------------------------------------
            if (aSecondMenu.gethBohtheia().isSelected() || aSecondMenu.getEpilogiKillerSudoku().isSelected()) {

                secondPanel = new JPanel();
                TitledBorder border = BorderFactory.createTitledBorder(borderName);
                secondPanel.setBorder(border);
                secondPanel.setLayout(new GridLayout(1,0));

                aLabel = new JLabel(borderName + " :");
                aTextField = new JTextField();
                aTextField.setEditable(false);

                secondPanel.add(aLabel, BorderLayout.NORTH);
                secondPanel.add(aTextField, BorderLayout.NORTH);

                add(secondPanel, BorderLayout.LINE_END);
            }

        //-----------------------------------------------------------------------------------------------------------------------------
        CheckButtonActionListener aCheckButtonActionListener = new CheckButtonActionListener(this);
        CheckButton = new JButton(ButtonName);
        CheckButton.addActionListener(aCheckButtonActionListener);

        add(firstPanel, BorderLayout.CENTER);
        add(CheckButton, BorderLayout.PAGE_END);
        pack();

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
