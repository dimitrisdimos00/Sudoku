package GUI.AllOfListeners;

import GUI.SudokuFrame.SudokuFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckButtonActionListener implements ActionListener {

    private SudokuFrame anSudokuFrame;

    public CheckButtonActionListener(SudokuFrame anSudokuFrame) {
        this.anSudokuFrame = anSudokuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //CheckIfItBelongsToTheArray();
    }


    //    private void CheckIfItBelongsToTheArray() {
//
//        boolean found = false;
//
//        if (anSudokuFrame.getNumbers()!=null) {
//            for (int i = 0; i< anSudokuFrame.getNumOfRows(); i++) {
//                for (int j = 0; j< anSudokuFrame.getNumOfColumns(); j++) {
//                    for (int k = 0; k< anSudokuFrame.getNumbers().length; k++) {
//                        if (anSudokuFrame.getTheField()[i][j].getText().equals(String.valueOf(anSudokuFrame.getNumbers()[k]))) {
//                            found = true;
//                            anSudokuFrame.getTheField()[i][j].setBackground(Color.green);
//                            break;
//                        }
//                    }
//                    if (!found && !(anSudokuFrame.getTheField()[i][j].getText().equals(""))) {
//                        anSudokuFrame.getTheField()[i][j].setBackground(Color.red);
//                    }
//                    found = false;
//                }
//            }
//        } else {
//            for (int i = 0; i< anSudokuFrame.getNumOfRows(); i++) {
//                for (int j = 0; j< anSudokuFrame.getNumOfColumns(); j++) {
//                    for (int k = 0; k< anSudokuFrame.getLetters().length; k++) {
//                        if (anSudokuFrame.getTheField()[i][j].getText().equals(Character.toString(anSudokuFrame.getLetters()[k]))) {
//                            found = true;
//                            anSudokuFrame.getTheField()[i][j].setBackground(Color.green);
//                            break;
//                        }
//                    }
//                    if (!found && !(anSudokuFrame.getTheField()[i][j].getText().equals(""))) {
//                        anSudokuFrame.getTheField()[i][j].setBackground(Color.red);
//                    }
//                    found = false;
//                }
//            }
//        }
//
//    }
}
