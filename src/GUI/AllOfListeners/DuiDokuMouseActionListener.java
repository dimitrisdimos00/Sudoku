package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Η DuiDokuMouseActionListener είναι επέκταση του interface MouseListener και ορίζει τί θα γίνεται όταν το ποντίκι
 * του χρήστη πατήσει, μπεί ή βγεί από ένα JTextField.
 *
 * @author Γιώργος Τσιφούτης
 */
public class DuiDokuMouseActionListener implements MouseListener {

    private int row;
    private int col;
    private SudokuFrame aSudokuFrame;

    /**
     * Απλά αναθέτω την γραμμη, στήλη και SudokuFrame στα αντίστοιχα ιδιοτικά πεδία.
     * @param aSudokuFrame Χρησιμοποιήται για να έχουμε πρόσβαση στο field από JTextField καθώς και εάν ο χρήστης
     *                     επέλεξε την βοήθεια ή όχι.
     * @param row Η σειρά του JTextField
     * @param col Η στήλη του JTextField
     */
    public DuiDokuMouseActionListener(SudokuFrame aSudokuFrame, int row, int col) {
        this.aSudokuFrame = aSudokuFrame;
        this.row = row;
        this.col = col;
    }

    /**
     * Ελέχγει εάν είναι κενό το JTextField, δεν υπάρχει άλλο ανοικτό JTextField καί δεν έχει μαύρο Background.
     * Μαύρο Background θα έχει όταν δεν μπορεί να εισαχθεί άλλος χαρακτήρας στο κουτάκι.
     * @param mouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (IsEmpty() && EverythingIsClosed() && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.black)
            aSudokuFrame.getTheField()[row][col].setEditable(true);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    /**
     * Ανανεώνει το JTextField της βοήθειας με το νέο String.
     * @param mouseEvent
     */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        if (aSudokuFrame.getaSecondMenu().gethBohtheia().isSelected())
            aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(renameString()));
    }

    /**
     * Όταν βγεί το ποντίκι από ένα JTextField τότε το κλείνει αλλά αν έχει γράψει ο χρήστης τότε το ξαναενεργοποιεί.
     * Τέλος εάν είναι χρωματισμένο το απενεργοποιεί άλλη μία φορά.
     * @param mouseEvent
     */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        aSudokuFrame.getTheField()[row][col].setEditable(false);

        if (!(IsEmpty()))
            aSudokuFrame.getTheField()[row][col].setEditable(true);

        if (aSudokuFrame.getTheField()[row][col].getBackground()== Color.green || aSudokuFrame.getTheField()[row][col].getBackground()== Color.red)
            aSudokuFrame.getTheField()[row][col].setEditable(false);
    }

    /**
     * @return Επιστρέφει true εάν το κουτάκι που πάτησε ο χρήστης είναι κενό.
     */
    private boolean IsEmpty() {
        return aSudokuFrame.getTheField()[row][col].getText().equals("");
    }

    /**
     *
     * @return Επιστρέφει true εάν όλα τα JTextField είναι κλειστά.
     */
    private boolean EverythingIsClosed() {
        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {
                if (aSudokuFrame.getTheField()[row][col].isEditable())
                    return false;
            }
        }
        return true;
    }

    /**
     *
     * @return Δημιουργεί και επιστρέφει το String με τους αριθμούς ή γράμματα που μπορούν να εισαχθούν στο επιλεγμένο
     * κουτάκι.
     */
    private String renameString() {

        StringBuilder theString;

        HashMap<Integer, Boolean> theIntegerMap = null;
        HashMap<Character, Boolean> theCharacterMap = null;

        theString = new StringBuilder();

        if (aSudokuFrame.getNumbers()!=null) {
            theIntegerMap = new HashMap<>();
            for (int i=0; i < aSudokuFrame.getNumbers().length; i++) {
                theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
            }
        } else {
            theCharacterMap = new HashMap<>();
            for (int i=0; i < aSudokuFrame.getLetters().length; i++) {
                theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
            }
        }

        if (theIntegerMap != null) {

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                if (aSudokuFrame.getaLogic().isElementInRow(row, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInBox(row, col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInColumn(col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
            }

            for (Map.Entry<Integer, Boolean> e : theIntegerMap.entrySet()) {
                if (!e.getValue()) {
                    theString.append(e.getKey()).append("/");
                }
            }

            if (theString.length() >= 1) {
                theString.deleteCharAt(theString.length() - 1);
            } else {
                theString.append("--------");
            }
        } else {

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                if (aSudokuFrame.getaLogic().isElementInRow(row, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInBox(row, col, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInColumn(col, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
            }

            for (Map.Entry<Character, Boolean> e : theCharacterMap.entrySet()) {
                if (!e.getValue()) {
                    theString.append(e.getKey()).append("/");
                }
            }

            if (theString.length() >= 1) {
                theString.deleteCharAt(theString.length() - 1);
            } else {
                theString.append("--------");
            }
        }
        return String.valueOf(theString);
    }
}
