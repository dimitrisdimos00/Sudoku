package GUI.AllOfListeners;

import GUI.AllTheMenus.EnglishMenu;
import GUI.AllTheMenus.GreekMenu;
import GUI.AllTheMenus.MainMenu;
import LOGIC.ENTRY_FILE_MANAGEMENT.Entry;
import LOGIC.ENTRY_FILE_MANAGEMENT.EntryFileManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuStartButtonActionListener implements ActionListener {

    private MainMenu aMainMenu;
    private String theUserName;
    private Entry theEntry;

    private ArrayList<Entry> allEntries;

    public MainMenuStartButtonActionListener(MainMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aMainMenu.setVisible(false);

        theUserName = aMainMenu.getUserNameTextField().getText();

        EntryFileManager anEntryFileManager = new EntryFileManager();
        allEntries = anEntryFileManager.getAllEntries();

        boolean found = false;
        for (int i = 0; i < allEntries.size(); i++) {
            if (theUserName.equals(allEntries.get(i).getName())) {
                theEntry = allEntries.get(i);
                found = true;
                break;
            }
        }

        if (!found) {
            theEntry = new Entry(theUserName);
            anEntryFileManager.addEntry(theEntry);
        }

        if (aMainMenu.getGreekRadioButton().isSelected()) {
            new GreekMenu(theEntry);
        } else if (aMainMenu.getEnglishRadioButton().isSelected()) {
            new EnglishMenu(theEntry);
        }
    }
}
