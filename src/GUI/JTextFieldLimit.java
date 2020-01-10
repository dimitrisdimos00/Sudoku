package GUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Η κλάση JTextFieldLimit, επέκταση της PlainDocument, είναι αυτή που ορίζει πόσους χαρακτήρες θα γραφούν στα JTextField
 * στα οποία ο χρήστης θα δώσει τους αριθμούς ή τα γράμματα.
 *
 * ΠΡΟΣΟΧΉ!!!!
 * Αυτή η κλάση βασίστηκε στο παρακάτω post: https://stackoverflow.com/questions/3519151/how-to-limit-the-number-of-characters-in-jtextfield
 *
 * @author Γιώργος Τσιφούτης
 */
public class JTextFieldLimit extends PlainDocument {

    private final int theLimit;

    public JTextFieldLimit(int theLimit) {
        this.theLimit = theLimit;
    }

    @Override
    public void insertString(int offs, String str, AttributeSet a)
            throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= theLimit) {
            super.insertString(offs, str, a);
        }
    }
}
