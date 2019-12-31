package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

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
        if (IsEmpty() && EverythingIsClosed() && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.black)
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
        aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(BlackBackground()));

        if (String.valueOf(BlackBackground()).equals("--------") && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.green && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.red)
            aSudokuFrame.getTheField()[row][col].setBackground(Color.black);

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
    private String BlackBackground() {

        StringBuilder theString;

        HashMap<Integer, Boolean> theIntegerMap = null;
        HashMap<Character, Boolean> theCharacterMap = null;

        theString = new StringBuilder();

        if (aSudokuFrame.getNumbers()!=null) {
            theIntegerMap = new HashMap<>();
            for (int i=0; i < aSudokuFrame.getNumbers().length; i++) {
                theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
            }
        } else {
            theCharacterMap = new HashMap<>();
            for (int i=0; i < aSudokuFrame.getLetters().length; i++) {
                theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
            }
        }

        if (theIntegerMap != null) {

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                if (aSudokuFrame.getaLogic().isElementInRow(row, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInBox(row, col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInColumn(col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
            }

            for (Map.Entry<Integer, Boolean> e : theIntegerMap.entrySet()) {
                if (!e.getValue()) {
                    theString.append(e.getKey()).append("/");
                }
            }

            if (theString.length() >= 1) {
                theString.deleteCharAt(theString.length() - 1);
            } else {
                theString.append("--------");
            }
        } else {

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                if (aSudokuFrame.getaLogic().isElementInRow(row, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInBox(row, col, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aSudokuFrame.getaLogic().isElementInColumn(col, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
            }

            for (Map.Entry<Character, Boolean> e : theCharacterMap.entrySet()) {
                if (!e.getValue()) {
                    theString.append(e.getKey()).append("/");
                }
            }

            if (theString.length() >= 1) {
                theString.deleteCharAt(theString.length() - 1);
            } else {
                theString.append("--------");
            }
        }
        return String.valueOf(theString);
    }
}
