package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;
import LOGIC.PUZZLE_LOGIC.Logic;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Αυτη η κλάση χρησιμοποιείται όταν έχει επιλεχθεί η βοήθεια ή το Killer Sudoku. Στην ουσία δείχνει στον χρήστη
 * μέσο της secondPanelTextField τους χαρακτήρες που μπορεί να εισάγει σε καθε κουτάκι που πατάει μέσα στο παιχνίδι
 * καθώς και το άθροισμα των JTextField με το ίδιο χρώμα Background.
 *
 * @author Γιώργος Τσιφούτης
 */
public class TextFieldFocusListener implements FocusListener {

    private SudokuFrame aSudokuFrame;
    private int row;
    private int col;
    private Logic aLogic;

    private StringBuilder theString;

    private HashMap<Integer, Boolean> theIntegerMap = null;
    private HashMap<Character, Boolean> theCharacterMap = null;

    //-------------------------------------------------------------------------------------

    public HashMap<Integer, Boolean> getTheIntegerMap() {
        return theIntegerMap;
    }
    public void setTheIntegerMap(HashMap<Integer, Boolean> theIntegerMap) {
        this.theIntegerMap = theIntegerMap;
    }

    public HashMap<Character, Boolean> getTheCharacterMap() {
        return theCharacterMap;
    }
    public void setTheCharacterMap(HashMap<Character, Boolean> theCharacterMap) {
        this.theCharacterMap = theCharacterMap;
    }

    //-------------------------------------------------------------------------------------

    /**
     * @param aSudokuFrame Χρησιμοποιήται για να έχουμε τον αριθμό των σειρών, στηλών, πρόσβαση σε κάθε JTextField
     *                     του SudokuFrame. Πρόσβαση στο JTextField της βοήθειας και των πληροφοριών για το
     *                     Killer Sudoku.
     * @param row η σειρά του JTextField που έχει επιλέξει ο χρήστης
     * @param col η στήλη του JTextField που έχει επιλέξει ο χρήστης
     * @param aLogic Αντικείμενο της Logic για να ελέγξουμε εάν ένα στοιχείο μπορεί να προστεθεί στο grid από
     *               JTextFields.
     */
    public TextFieldFocusListener(SudokuFrame aSudokuFrame, int row, int col, Logic aLogic) {
        this.aSudokuFrame = aSudokuFrame;
        this.row = row;
        this.col = col;
        this.aLogic = aLogic;

        forConstructor();
    }

    /**
     * Ελέχγει εάν το κουτάκι που πάτησε ο χρήστης είναι επιτρεπτό να πληρκτρολογήσει.
     *
     * @param focusEvent Ορισμα απο FocusEvent
     */
    @Override
    public void focusGained(FocusEvent focusEvent) {

        theString.setLength(0);

        if (aSudokuFrame.getTheField()[row][col].isEditable()) {
            forFocusGained();
        }
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {

    }

    /**
     * Δέσμευση χώρου για το String που θα χρησιμοποιήσουμε αργότερα και δημιουργώ ένα HashMap με τους χαρακτήρες που
     * μπορουν να μπούν και τους θέτω false
     *
     */
    private void forConstructor() {

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
    }

    /**
     * Η μέθοδος αυτή αποθηκεύει τον αριθμό που αντιπροωπεύει το άθροισμα των κουτακιών με το ίδιο χρώμα για την
     * Killer Sudoku στο TheSumTextField και δημιουργεί το String μέσω StringBuilder που θα αποθηκευτεί στο
     * SecondPanelTextField και θα δίχνει ποιοί χαρακτήρες μπορούν να μπούν στο κουτάκι που έχει επιλέξει ο χρήστης.
     *
     */
    private void forFocusGained() {

        if (aSudokuFrame.getaSecondMenu().getEpilogiKillerSudoku().isSelected()) {
            for (Map.Entry<Integer, Color> e : aSudokuFrame.getIntegerToColorMap().entrySet()) {
                if (aSudokuFrame.getTheField()[row][col].getBackground().equals(e.getValue())) {
                    aSudokuFrame.getTheSumTextField().setText(String.valueOf(e.getKey()));
                    break;
                }
            }
        }

        if (aSudokuFrame.getaSecondMenu().gethBohtheia().isSelected()) {
            if (theIntegerMap != null) {

                for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                    theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
                }

                for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                    if (aLogic.isElementInRow(row, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
                        theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                    }
                    if (aLogic.isElementInBox(row, col, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
                        theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                    }
                    if (aLogic.isElementInColumn(col, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
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
                aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(theString));

            } else {

                for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                    theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
                }

                for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                    if (aLogic.isElementInRow(row, aSudokuFrame.getLetters()[i])) {
                        theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                    }
                    if (aLogic.isElementInBox(row, col, aSudokuFrame.getLetters()[i])) {
                        theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                    }
                    if (aLogic.isElementInColumn(col, aSudokuFrame.getLetters()[i])) {
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
                aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(theString));
            }
        }
    }
}
