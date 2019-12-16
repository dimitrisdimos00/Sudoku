package GUI.AllOfListeners;

import GUI.AllTheMenus.*;
import GUI.Frames.Original_SudokuFrame;
import GUI.Frames.SudokuFramePROX;

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
            new SudokuFramePROX(aSecondMenu, 9, 9, "El");
        }
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            new SudokuFramePROX(aSecondMenu, 4, 4, "El");
        }
        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            new SudokuFramePROX(aSecondMenu, 9, 9, "El");
        }

    }
}
