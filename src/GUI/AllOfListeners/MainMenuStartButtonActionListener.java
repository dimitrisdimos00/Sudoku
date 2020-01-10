package GUI.AllOfListeners;

import GUI.AllTheMenus.EnglishMenu;
import GUI.AllTheMenus.GreekMenu;
import GUI.AllTheMenus.MainMenu;
import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;
import LOGIC.ENTRY_FILE_MANAGEMENT.EntryFileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Μέσα στην κλάση MainMenuStartButtonActionListener καθορίζεται τί θα κάνει το κουμπί από την κλάση MainMenu.
 *
 * Μόλις πατηθεί, κρύβει το πρώτο παράθυρο και παίρνει το ψευδώνυμο που έδωσε ο χρήστης για να ελέγξει εάν παίζει για
 * πρώτη φορά ή έχει ξαναπαίξει και μετά καλεί τον κατασκευαστή του δεύτερου παραθύρου.
 *
 * @author Γιώργος Τσιφούτης
 */
public class MainMenuStartButtonActionListener implements ActionListener {

    private MainMenu aMainMenu;
    private String theUserName;
    private Entry theEntry;

    public MainMenuStartButtonActionListener(MainMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aMainMenu.setVisible(false);

        theUserName = aMainMenu.getUserNameTextField().getText();

        EntryFileManager anEntryFileManager = new EntryFileManager();
        theEntry = anEntryFileManager.getEntry(theUserName);

        if (aMainMenu.getGreekRadioButton().isSelected()) {
            new GreekMenu(theEntry);
        } else if (aMainMenu.getEnglishRadioButton().isSelected()) {
            new EnglishMenu(theEntry);
        }
    }
}
