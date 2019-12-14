import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuStartButtonActionListener implements ActionListener {

    private MainMenu aMainMenu;

    MainMenuStartButtonActionListener(MainMenu aMainMenu) {
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
