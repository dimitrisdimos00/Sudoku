package GUI.AllTheMenus;

import GUI.AllOfListeners.*;
import LOGIC.FILE_MANAGEMENT.Entry;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SecondMenu extends JFrame{

    private Entry theEntry;
    private boolean fromGreekMenu;
    private String[] strings;

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

    //--------------------------------------------------------------------------------------------------

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

    public JCheckBox gethBohtheia() {
        return hBohtheia;
    }
    public void sethBohtheia(JCheckBox hBohtheia) {
        this.hBohtheia = hBohtheia;
    }

    public String[] getStrings() {
        return strings;
    }
    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public boolean isFromGreekMenu() {
        return fromGreekMenu;
    }
    public void setFromGreekMenu(boolean fromGreekMenu) {
        this.fromGreekMenu = fromGreekMenu;
    }

    public Entry getTheEntry() {
        return theEntry;
    }
    public void setTheEntry(Entry theEntry) {
        this.theEntry = theEntry;
    }

    //--------------------------------------------------------------------------------------------------
    SecondMenu(Entry anEntry) {
        this.theEntry = anEntry;
        fromGreekMenu = this instanceof GreekMenu? true : false;
        strings = new String[11];
    }

    void MenuStart() {
        setTitle(strings[0]);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EpilogiOriginalSudoku = new JRadioButton(strings[1]);
        EpilogiOriginalSudoku.setSelected(true);
        EpilogiKillerSudoku = new JRadioButton(strings[2]);
        EpilogiDuiDoku = new JRadioButton(strings[3]);

        EpilogesGiaSudoku = new ButtonGroup();
        EpilogesGiaSudoku.add(EpilogiOriginalSudoku);
        EpilogesGiaSudoku.add(EpilogiKillerSudoku);
        EpilogesGiaSudoku.add(EpilogiDuiDoku);

        TitledBorder border = BorderFactory.createTitledBorder(strings[4]);
        firstPanel = new JPanel(new GridLayout(0,1));
        firstPanel.setBorder(border);
        firstPanel.add(EpilogiOriginalSudoku);
        firstPanel.add(EpilogiKillerSudoku);
        firstPanel.add(EpilogiDuiDoku);

        add(firstPanel, BorderLayout.PAGE_START);
        pack();

        EpilogiArithmon = new JRadioButton(strings[5]);
        EpilogiArithmon.setSelected(true);
        EpilogiGrammaton = new JRadioButton(strings[6]);

        EpilogesGrammatonHArithmon = new ButtonGroup();
        EpilogesGrammatonHArithmon.add(EpilogiArithmon);
        EpilogesGrammatonHArithmon.add(EpilogiGrammaton);

        TitledBorder secondBorder = BorderFactory.createTitledBorder(strings[7]);
        secondPanel = new JPanel(new GridLayout(0,1));
        secondPanel.setBorder(secondBorder);
        secondPanel.add(EpilogiArithmon);
        secondPanel.add(EpilogiGrammaton);

        add(secondPanel, BorderLayout.WEST);
        pack();

        hBohtheia = new JCheckBox(strings[8]);
        hBohtheia.setSelected(false);

        TitledBorder thirdBorder = BorderFactory.createTitledBorder(strings[9]);
        thirdPanel = new JPanel(new GridLayout(0,1));
        thirdPanel.setBorder(thirdBorder);
        thirdPanel.add(hBohtheia);

        add(thirdPanel, BorderLayout.CENTER);
        pack();

        SecondMenuStartButtonActionListener actionListener = new SecondMenuStartButtonActionListener(this);

        startButton = new JButton(strings[10]);
        startButton.addActionListener(actionListener);
        add(startButton, BorderLayout.PAGE_END);

        setSize(450,225);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
