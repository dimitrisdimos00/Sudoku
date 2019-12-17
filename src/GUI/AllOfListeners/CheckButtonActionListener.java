package GUI.AllOfListeners;

import GUI.SudokuFrame.OriginalSudokuFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButtonActionListener implements ActionListener {

    private OriginalSudokuFrame anOriginalSudokuFrame;

    public CheckButtonActionListener(OriginalSudokuFrame anOriginalSudokuFrame) {
        this.anOriginalSudokuFrame = anOriginalSudokuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //CheckIfThereAreMultipleInTheIntireMap();

    }
    /*private void CheckIfThereAreMultipleInTheIntireMap() {

        boolean found = false;

        if (anOriginalSudokuFrame.getNumbers()!=null) {
            for (int i = 0; i< anOriginalSudokuFrame.getNumOfRows(); i++) {
                for (int j = 0; j< anOriginalSudokuFrame.getNumOfColumns(); j++) {
                    for (int k = 0; k< anOriginalSudokuFrame.getNumbers().length; k++) {
                        if (anOriginalSudokuFrame.getTheField()[i][j].getText().equals(String.valueOf(anOriginalSudokuFrame.getNumbers()[k]))) {
                            found = true;
                            anOriginalSudokuFrame.getTheField()[i][j].setBackground(Color.green);
                            break;
                        }
                    }
                    if (!found) {
                        if (!(anOriginalSudokuFrame.getTheField()[i][j].getText().equals("")))
                            anOriginalSudokuFrame.getTheField()[i][j].setBackground(Color.red);
                    }
                    found = false;
                }
            }
        } else {
            for (int i = 0; i< anOriginalSudokuFrame.getNumOfRows(); i++) {
                for (int j = 0; j< anOriginalSudokuFrame.getNumOfColumns(); j++) {
                    for (int k = 0; k< anOriginalSudokuFrame.getLetters().length; k++) {
                        if (anOriginalSudokuFrame.getTheField()[i][j].getText().equals(Character.toString(anOriginalSudokuFrame.getLetters()[k]))) {
                            found = true;
                            anOriginalSudokuFrame.getTheField()[i][j].setBackground(Color.green);
                            break;
                        }
                    }
                    if (!found) {
                        if (!(anOriginalSudokuFrame.getTheField()[i][j].getText().equals("")))
                            anOriginalSudokuFrame.getTheField()[i][j].setBackground(Color.red);
                    }
                    found = false;
                }
            }
        }

    }*/
}
