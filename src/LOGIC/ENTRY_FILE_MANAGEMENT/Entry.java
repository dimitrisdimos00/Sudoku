package LOGIC.ENTRY_FILE_MANAGEMENT;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * The class Entry contains the values needed for a player, like the name, which puzzles he has solved and the number of his
 * wins and his losses. It implements Serializable in order to be saved in files.
 * @author Δημήτρης Δήμος
 */
public class Entry implements Serializable {
    private String name;
    private ArrayList<Integer> unsolvedClassicPuzzles;
    private ArrayList<Integer> unsolvedKillerPuzzles;
    private int wins;
    private int losses;

    //-------------------------------------------
    public void setName(String name) {
        this.name = name;
    }
    public void setUnsolvedClassicPuzzles(ArrayList<Integer> unsolvedClassicPuzzles) {
        this.unsolvedClassicPuzzles = unsolvedClassicPuzzles;
    }
    public void setUnsolvedKillerPuzzles(ArrayList<Integer> unsolvedKillerPuzzles) {
        this.unsolvedKillerPuzzles = unsolvedKillerPuzzles;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public void setLosses(int losses) {
        this.losses = losses;
    }

    public String getName() {
        return name;
    }
    public ArrayList<Integer> getUnsolvedClassicPuzzles() {
        return unsolvedClassicPuzzles;
    }
    public ArrayList<Integer> getUnsolvedKillerPuzzles() {
        return unsolvedKillerPuzzles;
    }
    public int getWins() {
        return wins;
    }
    public int getLosses() {
        return losses;
    }
    //------------------------------------------

    /**
     * The constructor sets the private String field name to the given name String, wins = losses = 0,
     * and unsolvedClassicPuzzles = unsolvedKillerPuzzles = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9].
     * @param name is a String containing the name of the player.
     */
    public Entry(String name){
        this.name = name;
        unsolvedClassicPuzzles = new ArrayList<>();
        unsolvedKillerPuzzles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            unsolvedClassicPuzzles.add(i);
            unsolvedKillerPuzzles.add(i);
        }
        wins = losses = 0;
    }

    /**
     * Removes from the ArrayList unsolvedClassicPuzzles the given solved classic sudoku puzzle.
     * @param solvedPuzzle is the solved puzzle index (from 0 to 9).
     */
    public void classicPuzzleSolved(int solvedPuzzle) {
        unsolvedClassicPuzzles.remove(solvedPuzzle);
    }
    /**
     * Removes from the ArrayList unsolvedKillerPuzzles the given solved killer sudoku puzzle.
     * @param solvedPuzzle is the solved puzzle index (from 0 to 9).
     */
    public void killerPuzzleSolved(int solvedPuzzle) {
        unsolvedKillerPuzzles.remove(solvedPuzzle);
    }

    /**
     * This method increases wins by 1.
     */
    public void increaseWins() {
        wins ++;
    }
    /**
     * This method increases losses by 1.
     */
    public void increaseLoses() {
        losses ++;
    }

    /**
     * Returns the Entry object values as a String
     * @return the String containing the values separated by the character "-".
     */
    public String toString() {
        return name + "-" + unsolvedClassicPuzzles + "-" + unsolvedKillerPuzzles + "-" + wins + "-" + losses;
    }
}
