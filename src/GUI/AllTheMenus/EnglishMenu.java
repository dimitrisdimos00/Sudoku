package GUI.AllTheMenus;

public class EnglishMenu extends SecondMenu {

    public EnglishMenu() {
        this.getStrings()[0] = "Welcome!";
        this.getStrings()[1] = "Original Sudoku";
        this.getStrings()[2] = "Killer Sudoku";
        this.getStrings()[3] = "DuiDoku";
        this.getStrings()[4] = "Welcome to the game. Please choose one of the following: ";
        this.getStrings()[5] = "Numbers (1-9 OR 1-4)";
        this.getStrings()[6] = "Letters (A-I OR A-D)";
        this.getStrings()[7] = "Numbers or Letters? ";
        this.getStrings()[8] = "Help";
        this.getStrings()[9] = "Check if you need help during the game: ";
        this.getStrings()[10] = "Press me to start playing!";

        this.MenuStart();
    }

}
