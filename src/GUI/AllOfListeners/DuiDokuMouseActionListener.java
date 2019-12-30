package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DuiDokuMouseActionListener implements MouseListener {

    private boolean typed = false;
    private int row;
    private int col;
    private SudokuFrame aSudokuFrame;

    public DuiDokuMouseActionListener(SudokuFrame aSudokuFrame, int row, int col) {
        this.aSudokuFrame = aSudokuFrame;
        this.row = row;
        this.col = col;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (IsEmpty() && EverythingIsClosed())
            aSudokuFrame.getTheField()[row][col].setEditable(true);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        aSudokuFrame.getTheField()[row][col].setEditable(false);

        if (!(IsEmpty()))
            aSudokuFrame.getTheField()[row][col].setEditable(true);

        if (aSudokuFrame.getTheField()[row][col].getBackground()== Color.green || aSudokuFrame.getTheField()[row][col].getBackground()== Color.red)
            aSudokuFrame.getTheField()[row][col].setEditable(false);
    }

    private boolean IsEmpty() {
        return aSudokuFrame.getTheField()[row][col].getText().equals("");
    }
    private boolean EverythingIsClosed() {
        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {
                if (aSudokuFrame.getTheField()[row][col].isEditable())
                    return false;
            }
        }
        return true;
    }
}
