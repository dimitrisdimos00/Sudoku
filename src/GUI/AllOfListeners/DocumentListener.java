package GUI.AllOfListeners;

import GUI.AllTheMenus.MainMenu;

import javax.swing.event.DocumentEvent;

/**
 * Ελέγχει εάν έδωσε ο χρήστης έδωσε ψευδώνυμο και εάν δεν έδωσε το κουμπί απενεργοποιείται αλλιώς ενεργοποιείται.
 *
 * @author Γιώργος Τσιφούτης
 */
public class DocumentListener implements javax.swing.event.DocumentListener {

    private MainMenu aMainMenu;

    public DocumentListener(MainMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        ButtonChanger();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        ButtonChanger();
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        ButtonChanger();
    }

    public void ButtonChanger() {
        if (aMainMenu.getUserNameTextField().getText().equals("")){
            aMainMenu.getStartButton().setEnabled(false);
        } else {
            aMainMenu.getStartButton().setEnabled(true);
        }
    }
}
