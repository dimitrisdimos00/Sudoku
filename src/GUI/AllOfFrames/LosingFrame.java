package GUI.AllOfFrames;

import GUI.AllOfListeners.LosingButtonActionListener;
import LOGIC.FILE_MANAGEMENT.Entry;

import javax.swing.*;
import java.awt.*;

public class LosingFrame extends JFrame {

    private SudokuFrame aSudokuFrame;

    private String Title;
    private String message;
    private String ButtonName;
    private String PanelName;

    private JLabel losingLabel;
    private JButton losingButton;
    private Entry anEntry;

    public LosingFrame(SudokuFrame aSudokuFrame) {

        this.aSudokuFrame = aSudokuFrame;

        Title = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Μόλις Έχασες" : "You Lost" ;
        message = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Δυστυχώς μόλις έχασες!" : "Unfortunately You Lost!" ;
        ButtonName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Πάτα με για να κλέισει το παιχνίδι!" : "Click me to close the application" ;
        PanelName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Ψευδώνυμο" : "Νίκες / Ήττες" ;

        this.anEntry = aSudokuFrame.getaSecondMenu().getTheEntry();

        this.makeFrame();
    }

    void makeFrame() {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);

        losingLabel = new JLabel(message);

        LosingButtonActionListener theActionListener = new LosingButtonActionListener(this);
        losingButton = new JButton(ButtonName);
        losingButton.addActionListener(theActionListener);

        FlowLayout layout = new FlowLayout();

        JPanel firstPanel = new JPanel(new GridLayout(1,2));
        firstPanel.setBorder(BorderFactory.createTitledBorder(PanelName));

        JLabel UserNameLabel = new JLabel(anEntry.getName());
        JLabel StatsLabel = new JLabel(anEntry.getWins() + "/" + anEntry.getLosses());

        firstPanel.add(UserNameLabel);
        firstPanel.add(StatsLabel);

        setLayout(layout);
        add(losingLabel, BorderLayout.PAGE_START);
        add(firstPanel, BorderLayout.CENTER);
        add(losingButton, BorderLayout.PAGE_END);

        setSize(280,140);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
