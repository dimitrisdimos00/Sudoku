import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EnglishMenu extends JFrame {

    private JPanel firstPanel;
    private ButtonGroup EpilogesGiaSudoku;
    private JRadioButton EpilogiOriginalSudoku;
    private JRadioButton EpilogiKillerSudoku;
    private JRadioButton EpilogiDuiDoku;

    private JPanel secondPanel;
    private ButtonGroup EpilogesGrammatonHArithmon;
    private JRadioButton EpilogiArithmon;
    private JRadioButton EpilogiGrammaton;

    private JPanel thirdPanel;
    private JCheckBox hBohtheia;

    private JButton startButton;

    public JRadioButton getEpilogiOriginalSudoku() {
        return EpilogiOriginalSudoku;
    }
    public JRadioButton getEpilogiKillerSudoku() {
        return EpilogiKillerSudoku;
    }
    public JRadioButton getEpilogiDuiDoku() {
        return EpilogiDuiDoku;
    }

    public JRadioButton getEpilogiArithmon() {
        return EpilogiArithmon;
    }
    public JRadioButton getEpilogiGrammaton() {
        return EpilogiGrammaton;
    }

    EnglishMenu() {
        MenuStart();
    }

    private void MenuStart() {
        setTitle("Welcome!");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EpilogiOriginalSudoku = new JRadioButton("Original Sudoku");
        EpilogiOriginalSudoku.setSelected(true);
        EpilogiKillerSudoku = new JRadioButton("Killer Sudoku");
        EpilogiDuiDoku = new JRadioButton("DuiDoku");

        EpilogesGiaSudoku = new ButtonGroup();
        EpilogesGiaSudoku.add(EpilogiOriginalSudoku);
        EpilogesGiaSudoku.add(EpilogiKillerSudoku);
        EpilogesGiaSudoku.add(EpilogiDuiDoku);

        TitledBorder border = BorderFactory.createTitledBorder("Welcome to the game. Please choose one of the following: ");
        firstPanel = new JPanel(new GridLayout(0,1));
        firstPanel.setBorder(border);
        firstPanel.add(EpilogiOriginalSudoku);
        firstPanel.add(EpilogiKillerSudoku);
        firstPanel.add(EpilogiDuiDoku);

        add(firstPanel, BorderLayout.PAGE_START);
        pack();

        EpilogiArithmon = new JRadioButton("Numbers (1-9 OR 1-4)");
        EpilogiArithmon.setSelected(true);
        EpilogiGrammaton = new JRadioButton("Letters (A-I OR A-D)");

        EpilogesGrammatonHArithmon = new ButtonGroup();
        EpilogesGrammatonHArithmon.add(EpilogiArithmon);
        EpilogesGrammatonHArithmon.add(EpilogiGrammaton);

        TitledBorder secondBorder = BorderFactory.createTitledBorder("Numbers or Letters? ");
        secondPanel = new JPanel(new GridLayout(0,1));
        secondPanel.setBorder(secondBorder);
        secondPanel.add(EpilogiArithmon);
        secondPanel.add(EpilogiGrammaton);

        add(secondPanel, BorderLayout.WEST);
        pack();

        hBohtheia = new JCheckBox("Help");
        hBohtheia.setSelected(false);

        TitledBorder thirdBorder = BorderFactory.createTitledBorder("Check if you need help during the game: ");
        thirdPanel = new JPanel(new GridLayout(0,1));
        thirdPanel.setBorder(thirdBorder);
        thirdPanel.add(hBohtheia);

        add(thirdPanel, BorderLayout.CENTER);
        pack();

        englishStartButtonActionListener actionListener = new englishStartButtonActionListener(this);

        startButton = new JButton("Press me to start playing!");
        startButton.addActionListener(actionListener);
        add(startButton, BorderLayout.PAGE_END);

        setSize(450,225);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new EnglishMenu();
    }*/

}
