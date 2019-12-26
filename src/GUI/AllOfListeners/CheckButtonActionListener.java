package GUI.AllOfListeners;

import GUI.SudokuFrame.SudokuFrame;
import GUI.SudokuFrame.WinningFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButtonActionListener implements ActionListener {

    private SudokuFrame aSudokuFrame;

    public CheckButtonActionListener(SudokuFrame aSudokuFrame) {
        this.aSudokuFrame = aSudokuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        boolean found = false;

        for (int row=0; row < aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col < aSudokuFrame.getNumOfColumns(); col++) {

                if (aSudokuFrame.getTheField()[row][col].isEditable()) {

                    if (aSudokuFrame.getTheField()[row][col].getText().equals("")) {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                        continue;
                    } else if (aSudokuFrame.getLetters() != null) {
                        for (int k = 0; k < aSudokuFrame.getLetters().length; k++) {
                            if (aSudokuFrame.getTheField()[row][col].getText().equals(Character.toString(aSudokuFrame.getLetters()[k]))) {
                                found = true;
                                break;
                            }
                        }
                    } else {
                        for (int k = 0; k < aSudokuFrame.getNumbers().length; k++) {
                            if (aSudokuFrame.getTheField()[row][col].getText().equals(String.valueOf(aSudokuFrame.getNumbers()[k]))) {
                                found = true;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                        continue;
                    }

                    if (!aSudokuFrame.getaLogic().isElementInRow(row, Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText())) &&
                        !aSudokuFrame.getaLogic().isElementInColumn(col, Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText())) &&
                        !aSudokuFrame.getaLogic().isElementInBox(row, col, Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText()))) {

                        aSudokuFrame.getaLogic().insertElement(Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText()), row, col);
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.white);
                    } else if (Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText()) == (aSudokuFrame.getaLogic().getA()[row][col])) {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.white);
                    } else {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                    }

                }
            }
        }

        if (aSudokuFrame.getaLogic().hasWon()) {
            aSudokuFrame.setVisible(false);
            new WinningFrame(aSudokuFrame);
        }

    }
}