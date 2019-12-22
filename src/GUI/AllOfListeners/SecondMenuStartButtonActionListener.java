package GUI.AllOfListeners;

import GUI.AllTheMenus.*;
import GUI.SudokuFrame.KillerSudokuFrame;
import GUI.SudokuFrame.OriginalSudokuFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondMenuStartButtonActionListener implements ActionListener {

    private SecondMenu aSecondMenu;

    public SecondMenuStartButtonActionListener(SecondMenu aMainMenu) {
        this.aSecondMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aSecondMenu.setVisible(false);

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected()) {
            new OriginalSudokuFrame(aSecondMenu, 9, 9);
        }
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            //new KillerSudokuFrame(aSecondMenu, 9, 9);
        }
        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            new OriginalSudokuFrame(aSecondMenu, 4, 4);
        }
    }
}
