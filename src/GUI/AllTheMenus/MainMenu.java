package GUI.AllTheMenus;

import GUI.AllOfListeners.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 *  Η MainMenu αντιπροσωπεύει το αρχικό παράθυρο που θα εμφανίζεται στον χρήστη. Η MainMenu είναι επέκταση της JFrame
 *  για να είναι πιο εύκολη η υλοποίηση του παραθύρου. Μέσα σε αυτή την κλάση υλοποιείται η δυνατότητα στον χρήστη να
 *  δώσει ένα ψευδώνυμο το οποίο θα χρησιμοποιηθεί από τις υπόλοιπες κλάσεις και η επιλογή της γλώσσας μεταξύ Ελληνικά
 *  και Αγγλικά. Ακόμη προστίθεται ένα κουμπί το οποίο όταν πατηθεί θα εμφανίζει το δεύτερο παράθυρο.
 *
 * @author Γιώργος Τσιφούτης
 */
public class MainMenu extends JFrame {

    private JPanel firstPanel;
    private JLabel UserNameLabel;
    private JTextField UserNameTextField;

    private JPanel secondPanel;
    private ButtonGroup group;
    private JRadioButton greekRadioButton;
    private JRadioButton englishRadioButton;

    private JButton startButton;

    //--------------------------------------------------------------------------------------------------

    public JRadioButton getGreekRadioButton() {
        return greekRadioButton;
    }
    public JRadioButton getEnglishRadioButton() {
        return englishRadioButton;
    }
    public JTextField getUserNameTextField() {
        return UserNameTextField;
    }
    public JButton getStartButton() {
        return startButton;
    }

    //--------------------------------------------------------------------------------------------------

    public MainMenu() {
        MenuStart();
    }


    /**
     *  Η μέθοδος MenuStart() ευθύνεται για το τί θα εμφανιστεί στο παράθυρο. Το παράθυρο χρησιμοποιεί 2 JPanels για
     *  καλύτερη οργανοποίηση του παραθύρου. Στο 1ο JPanel χρησιμοποείται ένα JLabel και ένα JTextField στο οποίο
     *  JTextField ο χρήστης θα εισάγει το ψευδώνυμο που θα επιλέξει. Στο 2ο JPanel ο χρήστης επιλέγει την γλώσσα
     *  που θέλει χρησιμοποιόντας 2 RadioButtons, ένα για τα ελληνικά και 1 για τα αγγλικά τα οποία εισάγονται σε
     *  ένα group (αντικείμενο κλάσης ButtonGroup()) και στο τέλος του παραθύρου προστίθεται το κουμπί.
     *
     * @author Γιώργος Τσιφούτης
     */
    private void MenuStart() {
        setTitle("Sudoku");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        firstPanel = new JPanel(new GridLayout(1,2));
        UserNameLabel = new JLabel("(Υποχρεωτικό) Ψευδώνυμο / (Required) UserName: ");
        DocumentListener listener = new GUI.AllOfListeners.DocumentListener(this);
        UserNameTextField = new JTextField("");
        UserNameTextField.getDocument().addDocumentListener(listener);
        firstPanel.add(UserNameLabel);
        firstPanel.add(UserNameTextField);

        add(firstPanel, BorderLayout.PAGE_START);
        pack();

            TitledBorder border = BorderFactory.createTitledBorder("Επέλεξε γλώσσα / Choose Language: ");
            secondPanel = new JPanel(new GridLayout(1,2));
            secondPanel.setBorder(border);

            group = new ButtonGroup();
            greekRadioButton = new JRadioButton("Ελληνικά");
            greekRadioButton.setSelected(true);
            englishRadioButton = new JRadioButton("English");
            group.add(greekRadioButton);
            group.add(englishRadioButton);

            secondPanel.add(greekRadioButton);
            secondPanel.add(englishRadioButton);

            add(secondPanel, BorderLayout.CENTER);
            pack();

                MainMenuStartButtonActionListener actionListener = new MainMenuStartButtonActionListener(this);
                startButton = new JButton("Ξεκίνα / Start");
                startButton.setEnabled(false);
                startButton.addActionListener(actionListener);
                add(startButton, BorderLayout.PAGE_END);

        setSize(600,130);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
