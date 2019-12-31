package GUI.AllOfListeners;

import GUI.AllOfFrames.SudokuFrame;
import LOGIC.Logic;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;
import java.util.Map;

public class TextFieldFocusListener implements FocusListener {

    private SudokuFrame aSudokuFrame;
    private int row;
    private int col;
    private Logic aLogic;

    private StringBuilder theString;

    private HashMap<Integer, Boolean> theIntegerMap = null;
    private HashMap<Character, Boolean> theCharacterMap = null;

    //-------------------------------------------------------------------------------------

    public HashMap<Integer, Boolean> getTheIntegerMap() {
        return theIntegerMap;
    }
    public void setTheIntegerMap(HashMap<Integer, Boolean> theIntegerMap) {
        this.theIntegerMap = theIntegerMap;
    }

    public HashMap<Character, Boolean> getTheCharacterMap() {
        return theCharacterMap;
    }
    public void setTheCharacterMap(HashMap<Character, Boolean> theCharacterMap) {
        this.theCharacterMap = theCharacterMap;
    }

    //-------------------------------------------------------------------------------------

    public TextFieldFocusListener(SudokuFrame aSudokuFrame, int row, int col, Logic aLogic) {
        this.aSudokuFrame = aSudokuFrame;
        this.row = row;
        this.col = col;
        this.aLogic = aLogic;

        forConstructor();
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {

        theString.setLength(0);

        if (aSudokuFrame.getTheField()[row][col].isEditable()) {
            forFocusGained();
        }


    }

    @Override
    public void focusLost(FocusEvent focusEvent) {

    }

    private void forConstructor() {

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
    }

    private void forFocusGained() {
        if (theIntegerMap != null) {

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                theIntegerMap.put(aSudokuFrame.getNumbers()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getNumbers().length; i++) {
                if (aLogic.isElementInRow(row, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aLogic.isElementInBox(row, col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
                    theIntegerMap.replace(aSudokuFrame.getNumbers()[i], true);
                }
                if (aLogic.isElementInColumn(col, (char) (aSudokuFrame.getNumbers()[i]+'0'))) {
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
            aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(theString));

        } else {

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                theCharacterMap.put(aSudokuFrame.getLetters()[i], false);
            }

            for (int i = 0; i < aSudokuFrame.getLetters().length; i++) {
                if (aLogic.isElementInRow(row, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aLogic.isElementInBox(row, col, aSudokuFrame.getLetters()[i])) {
                    theCharacterMap.replace(aSudokuFrame.getLetters()[i], true);
                }
                if (aLogic.isElementInColumn(col, aSudokuFrame.getLetters()[i])) {
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
            aSudokuFrame.getSecondPanelTextField().setText(String.valueOf(theString));
        }
    }
}
