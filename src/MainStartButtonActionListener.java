import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainStartButtonActionListener implements ActionListener {

    private MainMenu aMainMenu;

    MainStartButtonActionListener(MainMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aMainMenu.setVisible(false);

        if (aMainMenu.getGreekRadioButton().isSelected()) {
            new GreekMenu();
        } else if (aMainMenu.getEnglishRadioButton().isSelected()) {
            new EnglishMenu();
        }
    }
}
