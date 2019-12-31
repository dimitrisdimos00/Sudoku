package GUI.AllOfFrames;

import GUI.AllOfListeners.CheckButtonActionListener;
import GUI.AllOfListeners.DuiDokuMouseActionListener;
import GUI.JTextFieldLimit;
import GUI.AllTheMenus.SecondMenu;
import GUI.AllOfListeners.TextFieldFocusListener;
import LOGIC.Logic;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SudokuFrame extends JFrame{

    private int width = 500;
    private int height = 500;
    private int[] numbers = null;
    private char[] letters = null;

    private SecondMenu aSecondMenu;

    private Logic aLogic;

    private String nameOfGame;
    private String borderName;
    private int numOfRows;
    private int numOfColumns;
    private JTextField[][] theField;

    private TextFieldFocusListener aTextFieldFocusListener;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;

    private JTextField secondPanelTextField;
    private JLabel secondPanelLabel;
    private JLabel thirdPanelLabel;

    private JButton CheckButton;
    private String ButtonName;

    //-------------------------------------------------------------------------------------------------


    public SecondMenu getaSecondMenu() {
        return aSecondMenu;
    }
    public void setaSecondMenu(SecondMenu aSecondMenu) {
        this.aSecondMenu = aSecondMenu;
    }

    public Logic getaLogic() {
        return aLogic;
    }
    public void setaLogic(Logic aLogic) {
        this.aLogic = aLogic;
    }

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

    public JTextField getSecondPanelTextField() {
        return secondPanelTextField;
    }
    public void setSecondPanelTextField(JTextField secondPanelTextField) {
        this.secondPanelTextField = secondPanelTextField;
    }

    public TextFieldFocusListener getaTextFieldFocusListener() {
        return aTextFieldFocusListener;
    }
    public void setaTextFieldFocusListener(TextFieldFocusListener aTextFieldFocusListener) {
        this.aTextFieldFocusListener = aTextFieldFocusListener;
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

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected()) {
            this.nameOfGame = "Original Sudoku";
            if (aSecondMenu.getEpilogiArithmon().isSelected())
                aLogic = new Logic(1, true, this);
            else
                aLogic = new Logic(1, false, this);

        }
        else if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            this.nameOfGame = "Killer Sudoku";
            /*if (aSecondMenu.getEpilogiArithmon().isSelected())
                aLogic = new Logic(2, true);
            else
                aLogic = new Logic(2, false);*/
        }
        else if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            this.nameOfGame = "Duidoku";
            if (aSecondMenu.getEpilogiArithmon().isSelected())
                aLogic = new Logic(3, true, this);
            else
                aLogic = new Logic(3, false, this);
        }

        this.ButtonName = aSecondMenu.isFromGreekMenu() ? "Έλεγχος" : " Check ";
        this.borderName = aSecondMenu.isFromGreekMenu() ? " Η Βοήθεια " : " The Help " ;
        this.secondPanelLabel = new JLabel(aSecondMenu.isFromGreekMenu() ? " Οι χαρακτήρες που επιτρέπονται στο επιλεγμένο κουτάκι είναι: " : " The Characters you can put in the current box are: ");
        this.thirdPanelLabel = new JLabel(aSecondMenu.isFromGreekMenu() ? " πληροφορίες " : " information ");

        this.aSecondMenu = aSecondMenu;
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;

        firstPanel = new JPanel(new GridLayout(numOfRows,numOfColumns));
        theField = new JTextField[numOfRows][numOfColumns];
        for (int i=0; i<numOfRows ;i++) {
            for (int j=0; j<numOfColumns ;j++) {
                theField[i][j] = new JTextField("");
                theField[i][j].setHorizontalAlignment(JTextField.CENTER);
                theField[i][j].setFont(new Font("Verdana", Font.BOLD,20));
                theField[i][j].setDocument(new JTextFieldLimit(1));
                if (this.aSecondMenu.gethBohtheia().isSelected()) {
                    aTextFieldFocusListener = new TextFieldFocusListener(this, i, j, aLogic);
                    theField[i][j].addFocusListener(aTextFieldFocusListener);
                }
                firstPanel.add(theField[i][j]);
            }
        }

        for (int row=0;row<numOfRows;row++) {
            for (int col=0;col<numOfColumns;col++) {
                if (aLogic.getSudoku()[row][col]=='0') {
                    theField[row][col].setText("");
                } else {
                    theField[row][col].setText(String.valueOf(aLogic.getSudoku()[row][col]));
                    theField[row][col].setEditable(false);
                }
            }
        }

        this.makeFrame();
    }

    private void makeFrame() {
        setTitle(nameOfGame);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//-------------------------------------------------------------------------------------------------------------------------------
        if (aSecondMenu.gethBohtheia().isSelected()) {

            secondPanel = new JPanel();
            TitledBorder border = BorderFactory.createTitledBorder(borderName);
            secondPanel.setBorder(border);

            secondPanelTextField = new JTextField("\t\t");
            secondPanelTextField.setEditable(false);
            secondPanelTextField.setPreferredSize(secondPanelTextField.getPreferredSize());

            secondPanel.add(secondPanelLabel);
            secondPanel.add(secondPanelTextField);
            secondPanel.setPreferredSize(new Dimension(500,80));
            add(secondPanel, BorderLayout.PAGE_START);
        }

        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {

            thirdPanel = new JPanel();
            thirdPanel.setBorder(BorderFactory.createTitledBorder(" Killer Sudoku" + thirdPanelLabel.getText()));

            add(thirdPanel, BorderLayout.LINE_END);
        }

        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            forDuidoku();
        }
//-------------------------------------------------------------------------------------------------------------------------------

        CheckButtonActionListener aCheckButtonActionListener = new CheckButtonActionListener(this);
        CheckButton = new JButton(ButtonName);
        CheckButton.addActionListener(aCheckButtonActionListener);

        add(firstPanel, BorderLayout.CENTER);
        add(CheckButton, BorderLayout.PAGE_END);
        pack();

        setSize(width, height);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void forDuidoku() {

        for (int row=0; row<this.getNumOfRows(); row++) {
            for (int col=0; col<this.getNumOfColumns(); col++) {
                this.getTheField()[row][col].setEditable(false);
                DuiDokuMouseActionListener duiDokuMouseActionListener = new DuiDokuMouseActionListener(this, row, col);
                this.getTheField()[row][col].addMouseListener(duiDokuMouseActionListener);
            }
        }
    }
}