package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;
import GUI.AllOfFrames.WinningFrame;

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
        if (aSudokuFrame.getaSecondMenu().getEpilogiOriginalSudoku().isSelected())
            forOriginalSudoku();
        if (aSudokuFrame.getaSecondMenu().getEpilogiDuiDoku().isSelected())
            forDuidoku();
    }

    private void forOriginalSudoku() {


        boolean found;

        for (int row=0; row < aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col < aSudokuFrame.getNumOfColumns(); col++) {

                found = false;

                if (aSudokuFrame.getTheField()[row][col].isEditable()) {

                    if (aSudokuFrame.getTheField()[row][col].getText().equals("")) {
                        aSudokuFrame.getaLogic().getSudoku()[row][col] = '0';
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
                        aSudokuFrame.getaLogic().getSudoku()[row][col] = '0';
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                        continue;
                    }

                    if (!aSudokuFrame.getaLogic().isElementInRow(row, aSudokuFrame.getTheField()[row][col].getText().charAt(0)) &&
                            !aSudokuFrame.getaLogic().isElementInColumn(col, aSudokuFrame.getTheField()[row][col].getText().charAt(0)) &&
                            !aSudokuFrame.getaLogic().isElementInBox(row, col, aSudokuFrame.getTheField()[row][col].getText().charAt(0))) {

                        aSudokuFrame.getaLogic().insertElement(row, col, aSudokuFrame.getTheField()[row][col].getText().charAt(0));
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.white);
                    } else if (aSudokuFrame.getTheField()[row][col].getText().equals(String.valueOf(aSudokuFrame.getaLogic().getSudoku()[row][col]))) {
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

    private void forDuidoku() {

        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {
                if (aSudokuFrame.getTheField()[row][col].isEditable()) {
                    if (aSudokuFrame.getaLogic().insertElement(row, col, aSudokuFrame.getTheField()[row][col].getText().charAt(0))) {
                        aSudokuFrame.getTheField()[row][col].setEditable(false);
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.green);
                    } else {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.gray);
                        return;
                    }
                    break;
                }
            }
        }

        if (DuiDokuIsFull()) {
            aSudokuFrame.setVisible(false);
            new WinningFrame(aSudokuFrame);
            return;
        }

        aSudokuFrame.getaLogic().computerPlays();

        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {

                if (aSudokuFrame.getaLogic().getSudoku()[row][col] != '0')
                    aSudokuFrame.getTheField()[row][col].setText(String.valueOf(aSudokuFrame.getaLogic().getSudoku()[row][col]));

                if (!(aSudokuFrame.getTheField()[row][col].getText().equals("")) && aSudokuFrame.getTheField()[row][col].getBackground() != Color.green)
                    aSudokuFrame.getTheField()[row][col].setBackground(Color.red);

                aSudokuFrame.getTheField()[row][col].setEditable(false);
            }
        }

        aSudokuFrame.getaLogic().showArray();
        System.out.println("---------------------------------------------");

        if (DuiDokuIsFull()) {
            aSudokuFrame.setVisible(false);
            new WinningFrame(aSudokuFrame);
            return;
        }
    }

    private boolean DuiDokuIsFull() {
        boolean full = true;

        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++){
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {
                if (aSudokuFrame.getTheField()[row][col].getBackground()!=Color.black &&
                    aSudokuFrame.getTheField()[row][col].getBackground()!=Color.red   &&
                    aSudokuFrame.getTheField()[row][col].getBackground()!=Color.green) {

                    full = false;
                    break;
                }
            }
        }

        return full;
    }
}