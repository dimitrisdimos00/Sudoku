package GUI.AllOfListeners;

import GUI.AllTheMenus.EnglishMenu;
import GUI.AllTheMenus.GreekMenu;
import GUI.AllTheMenus.MainMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuStartButtonActionListener implements ActionListener {

    private MainMenu aMainMenu;

    public MainMenuStartButtonActionListener(MainMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aMainMenu.setVisible(false);

        if (aMainMenu.getGreekRadioButton().isSelected()) {
            //new GreekMenu();
            new GreekMenu();
        } else if (aMainMenu.getEnglishRadioButton().isSelected()) {
            //new EnglishMenu();
            new EnglishMenu();
        }
    }
}
