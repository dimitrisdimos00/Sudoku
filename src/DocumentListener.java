import javax.swing.event.DocumentEvent;

public class DocumentListener implements javax.swing.event.DocumentListener {

    private MainMenu aMainMenu;

    DocumentListener(MainMenu aMainMenu) {
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
