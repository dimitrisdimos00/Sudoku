package GUI.AllOfListeners;

import GUI.AllTheMenus.*;
import GUI.Frames.SudokuFrame;

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
            //new Original_SudokuFrame();
            new SudokuFrame(aSecondMenu, 9, 9);
        }
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            new SudokuFrame(aSecondMenu, 4, 4);
        }
        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            new SudokuFrame(aSecondMenu, 9, 9);
        }

    }
}
