import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class englishStartButtonActionListener implements ActionListener {

    private EnglishMenu aMainMenu;

    englishStartButtonActionListener(EnglishMenu aMainMenu) {
        this.aMainMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aMainMenu.setVisible(false);

        if (aMainMenu.getEpilogiOriginalSudoku().isSelected()) {
            new Original_SudokuFrame();
        }
        if (aMainMenu.getEpilogiKillerSudoku().isSelected()) {

        }
        if (aMainMenu.getEpilogiDuiDoku().isSelected()) {

        }

    }
}
