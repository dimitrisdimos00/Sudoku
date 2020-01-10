package GUI.AllOfListeners;

import GUI.AllOfFrames.LosingFrame;
import GUI.AllOfFrames.SudokuFrame;
import GUI.AllOfFrames.WinningFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CheckButtonActionListener implements ActionListener {

    private SudokuFrame aSudokuFrame;

    public CheckButtonActionListener(SudokuFrame aSudokuFrame) {
        this.aSudokuFrame = aSudokuFrame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (aSudokuFrame.getaSecondMenu().getEpilogiOriginalSudoku().isSelected())
            forOriginalSudoku();
        if (aSudokuFrame.getaSecondMenu().getEpilogiDuiDoku().isSelected()) {

            boolean typed = false;

            newBlackTextFields();

            for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
                for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {
                    if (aSudokuFrame.getTheField()[row][col].isEditable()) {
                        if ((!(aSudokuFrame.getTheField()[row][col].getText().equals(""))) && aSudokuFrame.getaLogic().insertElement(row, col, aSudokuFrame.getTheField()[row][col].getText().charAt(0))) {
                            aSudokuFrame.getTheField()[row][col].setEditable(false);
                            aSudokuFrame.getTheField()[row][col].setBackground(Color.green);
                            typed = true;
                        } else {
                            aSudokuFrame.getTheField()[row][col].setBackground(Color.gray);
                            return;
                        }
                        break;
                    }
                }
            }

            if (DuiDokuIsFull()) {
                aSudokuFrame.getaSecondMenu().getTheEntry().increaseWins();
                aSudokuFrame.getaSecondMenu().getTheEntry().updateEntry();
                aSudokuFrame.setVisible(false);
                new WinningFrame(aSudokuFrame);
            } else if (typed) {

                forDuidoku();

                newBlackTextFields();

                if (DuiDokuIsFull()) {
                    aSudokuFrame.getaSecondMenu().getTheEntry().increaseLoses();
                    aSudokuFrame.getaSecondMenu().getTheEntry().updateEntry();
                    aSudokuFrame.setVisible(false);
                    new LosingFrame(aSudokuFrame);
                }
            }
        }
        if (aSudokuFrame.getaSecondMenu().getEpilogiKillerSudoku().isSelected()) {
            forKillerSudoku();
        }
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

        aSudokuFrame.getaDuidoku().computerPlays();

        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col<aSudokuFrame.getNumOfColumns(); col++) {

                if (aSudokuFrame.getaLogic().getSudoku()[row][col] != '0')
                    aSudokuFrame.getTheField()[row][col].setText(String.valueOf(aSudokuFrame.getaLogic().getSudoku()[row][col]));

                if (!(aSudokuFrame.getTheField()[row][col].getText().equals("")) && aSudokuFrame.getTheField()[row][col].getBackground() != Color.green)
                    aSudokuFrame.getTheField()[row][col].setBackground(Color.red);

                aSudokuFrame.getTheField()[row][col].setEditable(false);
            }
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
    private void newBlackTextFields() {

        for (int row=0; row<aSudokuFrame.getNumOfRows(); row++) {
            for (int col=0; col < aSudokuFrame.getNumOfColumns(); col++) {

                StringBuilder theString;

                HashMap<Integer, Boolean> theIntegerMap = null;
                HashMap<Character, Boolean> theCharacterMap = null;

                theString = new StringBuilder();

                if (aSudokuFrame.getNumbers() != null) {
                    theIntegerMap = new HashMap<>();
                    for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                        theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
                    }
                } else {
                    theCharacterMap = new HashMap<>();
                    for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                        theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
                    }
                }

                if (theIntegerMap != null) {

                    for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                        theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
                    }

                    for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                        if (aSudokuFrame.getaLogic().isElementInRow(row, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
                            theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                        }
                        if (aSudokuFrame.getaLogic().isElementInBox(row, col, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
                            theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                        }
                        if (aSudokuFrame.getaLogic().isElementInColumn(col, (char) (aSudokuFrame.getNumbers()[i] + '0'))) {
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
                if (String.valueOf(theString).equals("--------") && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.green && aSudokuFrame.getTheField()[row][col].getBackground()!=Color.red) {
                    aSudokuFrame.getTheField()[row][col].setBackground(Color.black);
                }
            }
        }
    }

    private void forKillerSudoku() {

    }
}