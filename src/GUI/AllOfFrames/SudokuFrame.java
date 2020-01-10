package GUI.AllOfFrames;

import GUI.AllOfListeners.CheckButtonActionListener;
import GUI.AllOfListeners.DuiDokuMouseActionListener;
import GUI.JTextFieldLimit;
import GUI.AllTheMenus.SecondMenu;
import GUI.AllOfListeners.TextFieldFocusListener;
import LOGIC.PUZZLE_LOGIC.Duidoku;
import LOGIC.PUZZLE_LOGIC.KillerSudoku;
import LOGIC.PUZZLE_LOGIC.Logic;
import LOGIC.PUZZLE_LOGIC.Sudoku;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class SudokuFrame extends JFrame{

    private HashMap<Integer, Color> IntegerToColorMap;

    private int width = 500;
    private int height = 500;
    private int[] numbers = null;
    private char[] letters = null;

    private SecondMenu aSecondMenu;

    private Logic aLogic;
    private Sudoku aSudoku;
    private KillerSudoku aKillerSudoku;
    private Duidoku aDuidoku;

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

    private JTextField theSumTextField;
    //-------------------------------------------------------------------------------------------------


    public HashMap<Integer, Color> getIntegerToColorMap() {
        return IntegerToColorMap;
    }
    public void setIntegerToColorMap(HashMap<Integer, Color> integerToColorMap) {
        IntegerToColorMap = integerToColorMap;
    }

    public JTextField getTheSumTextField() {
        return theSumTextField;
    }
    public void setTheSumTextField(JTextField theSumTextField) {
        this.theSumTextField = theSumTextField;
    }

    public SecondMenu getaSecondMenu() {
        return aSecondMenu;
    }
    public void setaSecondMenu(SecondMenu aSecondMenu) {
        this.aSecondMenu = aSecondMenu;
    }

    public Sudoku getaSudoku() {
        return aSudoku;
    }
    public void setaSudoku(Sudoku aSudoku) {
        this.aSudoku = aSudoku;
    }

    public KillerSudoku getaKillerSudoku() {
        return aKillerSudoku;
    }
    public void setaKillerSudoku(KillerSudoku aKillerSudoku) {
        this.aKillerSudoku = aKillerSudoku;
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

    public Logic getaLogic() {
        return aLogic;
    }
    public void setaLogic(Logic aLogic) {
        this.aLogic = aLogic;
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

    public Duidoku getaDuidoku() {
        return aDuidoku;
    }
    public void setaDuidoku(Duidoku aDuidoku) {
        this.aDuidoku = aDuidoku;
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
                aSudoku = new Sudoku(true, aSecondMenu.getTheEntry().getUnsolvedClassicPuzzles());
            else
                aSudoku = new Sudoku(false, aSecondMenu.getTheEntry().getUnsolvedClassicPuzzles());
            aLogic = aSudoku;
        }
        else if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            this.nameOfGame = "Killer Sudoku";
            if (aSecondMenu.getEpilogiArithmon().isSelected())
                aKillerSudoku = new KillerSudoku(true, aSecondMenu.getTheEntry().getUnsolvedKillerPuzzles());
            else
                aKillerSudoku = new KillerSudoku(false, aSecondMenu.getTheEntry().getUnsolvedKillerPuzzles());
            aLogic = aKillerSudoku;
        }
        else if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            this.nameOfGame = "Duidoku";
            if (aSecondMenu.getEpilogiArithmon().isSelected())
                aDuidoku = new Duidoku(true, this);
            else
                aDuidoku = new Duidoku(false, this);
            aLogic = aDuidoku;
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
        setResizable(true);
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
            Random random = new Random();
            IntegerToColorMap = new HashMap<>();

            for (Integer i : aKillerSudoku.getUniqueNumbers()) {
                IntegerToColorMap.put(i, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
            }

            for (int row=0; row<this.getNumOfRows(); row++) {
                for (int col=0; col<this.getNumOfColumns(); col++) {
                    this.getTheField()[row][col].setBackground(IntegerToColorMap.get(aKillerSudoku.getSums()[row][col]));
                }
            }

            thirdPanel = new JPanel();
            thirdPanel.setBorder(BorderFactory.createTitledBorder(" Killer Sudoku" + thirdPanelLabel.getText()));
            thirdPanel.setLayout(new GridLayout(0,1));

            JLabel theText = new JLabel("Το άθροισμα των κουτακίων με το ίδιο χρώμα με αυτό πρέπει να είναι:");
            theSumTextField = new JTextField();
            theSumTextField.setEditable(false);

            thirdPanel.add(theText);
            thirdPanel.add(theSumTextField);

            if (aSecondMenu.gethBohtheia().isSelected()) {

                JPanel BoxPanel = new JPanel();
                BoxPanel.setLayout(new BoxLayout(BoxPanel, BoxLayout.Y_AXIS));

                BoxPanel.add(secondPanel);
                BoxPanel.add(thirdPanel);

                add(BoxPanel, BorderLayout.PAGE_START);
                height += 60;
            } else
                add(thirdPanel, BorderLayout.PAGE_START);
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