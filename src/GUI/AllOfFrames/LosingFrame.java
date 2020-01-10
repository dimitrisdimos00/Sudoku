package GUI.AllOfFrames;

import GUI.AllOfListeners.LosingButtonActionListener;
import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;

import javax.swing.*;
import java.awt.*;

/**
 * Η LosingFrame αποτελεί το παράθυρο που θα εμφανίζεται όταν ο χρήστης χάσει στο DuiDoku. Μέσα σε αυτό εμφανίζεται
 * το ψευδώνυμο που έδωσε καθώς και τα στατιστικά που είναι συνδεδεμένα με αυτό το ψευδώνυμο. Χρησιμοποιείται, τέλος,
 * ένα επιπλέον κουμπί για να κλείσει την εφαρμογή.
 *
 * @author Γιώργος Τσιφούτης
 */
public class LosingFrame extends JFrame {

    private String Title;
    private String ButtonName;
    private String PanelName;

    private JButton losingButton;
    private Entry anEntry;

    public LosingFrame(SudokuFrame aSudokuFrame) {

        Title = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Έχασες" : "You Lost" ;
        ButtonName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Πάτα με για να κλέισει το παιχνίδι!" : "Click me to close the application" ;
        PanelName = aSudokuFrame.getaSecondMenu().isFromGreekMenu() ? "Ψευδώνυμο: Νίκες / Ήττες" : "Nickname: Wins / Loses" ;

        this.anEntry = aSudokuFrame.getaSecondMenu().getTheEntry();

        this.makeFrame();
    }

    void makeFrame() {
        setTitle(Title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        LosingButtonActionListener theActionListener = new LosingButtonActionListener(this);
        losingButton = new JButton(ButtonName);
        losingButton.addActionListener(theActionListener);

        JPanel firstPanel = new JPanel(new GridLayout(0,2,30,0));
        firstPanel.setBorder(BorderFactory.createTitledBorder(PanelName));

        JLabel UserNameLabel = new JLabel(anEntry.getName() + ":");
        JLabel StatsLabel = new JLabel(anEntry.getWins() + "/" + anEntry.getLosses());

        firstPanel.add(UserNameLabel);
        firstPanel.add(StatsLabel);

        add(firstPanel, BorderLayout.CENTER);
        add(losingButton, BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
