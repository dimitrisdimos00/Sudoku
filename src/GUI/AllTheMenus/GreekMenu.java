package GUI.AllTheMenus;

import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;

/**
 * Η κλάση GreekMenu είναι επέκταση της SecondMenu και ευθύνεται στο να είναι το 2ο παράθυρο στα ελληνικά.
 *
 * @author Γιώργος Τσιφούτης
 */
public class GreekMenu extends SecondMenu {

    public GreekMenu(Entry anEntry) {
        super(anEntry);
        this.getStrings()[0] = "Καλωσόρισες!";
        this.getStrings()[1] = "Original Sudoku";
        this.getStrings()[2] = "Killer Sudoku";
        this.getStrings()[3] = "DuiDoku";
        this.getStrings()[4] = "Καλως Όρισες στο παιχνίδι. Διάλεξε μία επιλόγη: ";
        this.getStrings()[5] = "Αριθμοί (1-9 Ή 1-4)";
        this.getStrings()[6] = "Γράμματα (A-I Ή A-D)";
        this.getStrings()[7] = "Αριθμοί ή Γράμματα? ";
        this.getStrings()[8] = "Βοήθεια";
        this.getStrings()[9] = "Επέλεξε το κουτί αν θα ήθελες βοήθεια: ";
        this.getStrings()[10] = "Πάτα με για να παίξεις!";

        this.MenuStart();
    }
}
