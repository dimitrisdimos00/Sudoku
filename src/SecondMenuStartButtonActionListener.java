import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondMenuStartButtonActionListener implements ActionListener {

    private SecondMenu aSecondMenu;

    SecondMenuStartButtonActionListener(SecondMenu aMainMenu) {
        this.aSecondMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aSecondMenu.setVisible(false);

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected()) {
            new Original_SudokuFrame();
        }
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {

        }
        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {

        }

    }
}
