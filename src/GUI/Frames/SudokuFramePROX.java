package GUI.Frames;

import GUI.AllTheMenus.JTextFieldLimit;
import GUI.AllTheMenus.SecondMenu;

import javax.swing.*;
import java.awt.*;

public class SudokuFramePROX extends JFrame{

    private String nameOfGame;
    private int numOfRows;
    private int numOfColumns;
    private String ButtonName;

    private JPanel firstPanel;
    private JTextField[][] theField;

    private JButton CheckButton;

    public SudokuFramePROX(SecondMenu aSecondMenu, int numOfRows, int numOfColumns, String ButtonName) {

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected())
            this.nameOfGame = "Original Sudoku";
        else if (aSecondMenu.getEpilogiKillerSudoku().isSelected())
            this.nameOfGame = "Killer Sudoku";
        else if (aSecondMenu.getEpilogiDuiDoku().isSelected())
            this.nameOfGame = "Duidoku";

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

        CheckButton = new JButton(ButtonName);
        // heckButton.addActionListener();

        add(firstPanel);
        add(CheckButton, BorderLayout.PAGE_END);
        pack();

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
