import javax.swing.*;
import java.awt.*;

abstract class SudokuFramePROX extends JFrame{

    private String nameOfGame;
    private int numOfRows;
    private int numOfColumns;
    private String ButtonName;

    private JPanel firstPanel;
    private JTextField[][] theField;

    private JButton CheckButton;

    SudokuFramePROX(String nameOfGame, int numOfRows, int numOfColumns, String ButtonName) {
        this.nameOfGame = nameOfGame;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.ButtonName = ButtonName;
        makeFrame();
    }

    private void makeFrame() {
        setTitle("Original Sudoku");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPanel = new JPanel(new GridLayout(9,9));
        theField = new JTextField[9][9];
        for (int i=0; i<9 ;i++) {
            for (int j=0;j<9;j++) {
                theField[i][j] = new JTextField("");
                theField[i][j].setHorizontalAlignment(JTextField.CENTER);
                theField[i][j].setFont(new Font("Verdana", Font.BOLD,20));
                theField[i][j].setDocument(new JTextFieldLimit(1));
                firstPanel.add(theField[i][j]);
            }
        }

        CheckButton = new JButton("Check");
        // heckButton.addActionListener();

        add(firstPanel);
        add(CheckButton, BorderLayout.PAGE_END);
        pack();

        setSize(500,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
