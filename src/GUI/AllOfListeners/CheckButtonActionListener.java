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

        if (aSudokuFrame.getNumbers()!=null) {
            for (int i=0; i<aSudokuFrame.getNumOfRows(); i++) {
                for (int j=0; j<aSudokuFrame.getNumOfColumns(); j++) {
                    for (int k=0; k<aSudokuFrame.getNumbers().length; k++) {
                        if (aSudokuFrame.getTheField()[i][j].getText().equals(String.valueOf(aSudokuFrame.getNumbers()[k]))) {
                            found = true;
                            aSudokuFrame.getTheField()[i][j].setBackground(Color.green);
                            break;
                        }
                    }
                    if (!found) {
                        if (!(aSudokuFrame.getTheField()[i][j].getText().equals("")))
                            aSudokuFrame.getTheField()[i][j].setBackground(Color.red);
                    }
                    found = false;
                }
            }
        } else {
            for (int i=0; i<aSudokuFrame.getNumOfRows(); i++) {
                for (int j=0; j<aSudokuFrame.getNumOfColumns(); j++) {
                    for (int k=0; k<aSudokuFrame.getLetters().length; k++) {
                        if (aSudokuFrame.getTheField()[i][j].getText().equals(Character.toString(aSudokuFrame.getLetters()[k]))) {
                            found = true;
                            aSudokuFrame.getTheField()[i][j].setBackground(Color.green);
                            break;
                        }
                    }
                    if (!found) {
                        if (!(aSudokuFrame.getTheField()[i][j].getText().equals("")))
                            aSudokuFrame.getTheField()[i][j].setBackground(Color.red);
                    }
                    found = false;
                }
            }
        }
    }
}
