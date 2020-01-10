package GUI.AllOfListeners;

import GUI.AllTheMenus.*;
import GUI.AllOfFrames.SudokuFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Η SecondMenuStartButtonActionListener ειναι η ActionListener για το κουμπί του 2ου παραθύρου και είναι αυτό που
 * καλεί την SudokuFrame για να αρχίσει το παιχνίδι.
 *
 * @author Γιώργος Τσιφούτης
 */
public class SecondMenuStartButtonActionListener implements ActionListener {

    private SecondMenu aSecondMenu;

    public SecondMenuStartButtonActionListener(SecondMenu aMainMenu) {
        this.aSecondMenu = aMainMenu;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        aSecondMenu.setVisible(false);

        if (aSecondMenu.getEpilogiOriginalSudoku().isSelected()) {
            new SudokuFrame(aSecondMenu, 9, 9);
        }
        if (aSecondMenu.getEpilogiKillerSudoku().isSelected()) {
            new SudokuFrame(aSecondMenu, 9, 9);
        }
        if (aSecondMenu.getEpilogiDuiDoku().isSelected()) {
            new SudokuFrame(aSecondMenu, 4, 4);
        }
    }
}
