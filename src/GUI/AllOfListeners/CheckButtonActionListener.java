package GUI.AllOfListeners;

import GUI.SudokuFrame.SudokuFrame;

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
                    }
                    else if (aSudokuFrame.getLetters() != null) {
                        for (int k = 0; k < aSudokuFrame.getLetters().length; k++) {
                            if (aSudokuFrame.getTheField()[row][col].getText().equals(Character.toString(aSudokuFrame.getLetters()[k]))) {
                                System.out.println(aSudokuFrame.getTheField()[row][col].getText());
                                found = true;
                                aSudokuFrame.getTheField()[row][col].setBackground(Color.white);
                                break;
                            }
                        }
                    } else {
                        for (int k = 0; k < aSudokuFrame.getNumbers().length; k++) {
                            if (aSudokuFrame.getTheField()[row][col].getText().equals(String.valueOf(aSudokuFrame.getNumbers()[k]))) {
                                System.out.println(aSudokuFrame.getTheField()[row][col].getText());
                                found = true;
                                aSudokuFrame.getTheField()[row][col].setBackground(Color.white);
                                break;
                            }
                        }
                    }

                    if (!found) {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                        continue;
                    }

                    if (!(aSudokuFrame.getaLogic().insertElement(Integer.parseInt(aSudokuFrame.getTheField()[row][col].getText()), row, col))) {
                        aSudokuFrame.getTheField()[row][col].setBackground(Color.red);
                    }

                }
            }
        }
    }
}
