import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GreekMenu extends JFrame {

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

    GreekMenu() {
        MenuStart();
    }

    private void MenuStart() {
        setTitle("Καλωσόρισες!");
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

        TitledBorder border = BorderFactory.createTitledBorder("Καλως Όρισες στο παιχνίδι. Διάλεξε μία επιλόγη: ");
        firstPanel = new JPanel(new GridLayout(0,1));
        firstPanel.setBorder(border);
        firstPanel.add(EpilogiOriginalSudoku);
        firstPanel.add(EpilogiKillerSudoku);
        firstPanel.add(EpilogiDuiDoku);

        add(firstPanel, BorderLayout.PAGE_START);
        pack();

            EpilogiArithmon = new JRadioButton("Αριθμοί (1-9 Ή 1-4)");
            EpilogiArithmon.setSelected(true);
            EpilogiGrammaton = new JRadioButton("Γράμματα (A-I Ή A-D)");

            EpilogesGrammatonHArithmon = new ButtonGroup();
            EpilogesGrammatonHArithmon.add(EpilogiArithmon);
            EpilogesGrammatonHArithmon.add(EpilogiGrammaton);

            TitledBorder secondBorder = BorderFactory.createTitledBorder("Αριθμοί ή Γράμματα? ");
            secondPanel = new JPanel(new GridLayout(0,1));
            secondPanel.setBorder(secondBorder);
            secondPanel.add(EpilogiArithmon);
            secondPanel.add(EpilogiGrammaton);

            add(secondPanel, BorderLayout.WEST);
            pack();

                hBohtheia = new JCheckBox("Βοήθεια");
                hBohtheia.setSelected(false);

                TitledBorder thirdBorder = BorderFactory.createTitledBorder("Επέλεξε το κουτί αν θα ήθελες βοήθεια: ");
                thirdPanel = new JPanel(new GridLayout(0,1));
                thirdPanel.setBorder(thirdBorder);
                thirdPanel.add(hBohtheia);

                add(thirdPanel, BorderLayout.CENTER);
                pack();

                    greekStartButtonActionListener actionListener = new greekStartButtonActionListener(this);

                    startButton = new JButton("Πάτα με για να παίξεις!");
                    startButton.addActionListener(actionListener);
                    add(startButton, BorderLayout.PAGE_END);

        setSize(450,225);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /*public static void main(String[] args) {
        new GreekMenu();
    }*/

}
