package GUI.AllOfFrames;

import GUI.AllOfListeners.WinningButtonActionListener;
import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;

import javax.swing.*;
import java.awt.*;

public class WinningFrame extends JFrame {

    private SudokuFrame aSudokuFrame;

    private String Title;
    private String message;
    private String ButtonName;
    private String PanelName;

    private JLabel winningLabel;
    private JButton winningButton;
    private Entry anEntry;

    public WinningFrame(SudokuFrame aSudokuFrame) {

        this.aSudokuFrame = aSudokuFrame;

        Title = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Συγχαρητήρια" : "Congratulations" ;
        message = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Συγχαρητήρια μόλις κέρδισες!" : "Congratulations You Won!" ;
        ButtonName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Πάτα με για να κλέισει το παιχνίδι!" : "Click me to close the application" ;
        PanelName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Ψευδώνυμο" : "Νίκες / Ήττες" ;

        this.anEntry = aSudokuFrame.getaSecondMenu().getTheEntry();

        this.makeFrame();
    }

    void makeFrame() {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        winningLabel = new JLabel(message);

        WinningButtonActionListener theActionListener = new WinningButtonActionListener(this);
        winningButton = new JButton(ButtonName);
        winningButton.addActionListener(theActionListener);

        FlowLayout layout = new FlowLayout();

        JPanel firstPanel = new JPanel(new GridLayout(1,2));
        firstPanel.setBorder(BorderFactory.createTitledBorder(PanelName));

        JLabel UserNameLabel = new JLabel(anEntry.getName());
        JLabel StatsLabel = new JLabel(anEntry.getWins() + "/" + anEntry.getLosses());

        firstPanel.add(UserNameLabel);
        firstPanel.add(StatsLabel);

        setLayout(layout);
        add(winningLabel, BorderLayout.PAGE_START);
        add(firstPanel, BorderLayout.CENTER);
        add(winningButton, BorderLayout.PAGE_END);

        setSize(280,140);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
