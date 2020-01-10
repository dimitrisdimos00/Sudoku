package LOGIC.ENTRY_FILE_MANAGEMENT;

import java.io.Serializable;
import java.util.ArrayList;

public class Entry implements Serializable {
    private String name;
    private ArrayList<Integer> unsolvedClassicPuzzles;
    private ArrayList<Integer> unsolvedKillerPuzzles;
    private int wins;
    private int losses;
    //constructor
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

    public void classicPuzzleSolved(int solvedPuzzle) {
        unsolvedClassicPuzzles.remove(solvedPuzzle);
    }

    public void killerPuzzleSolved(int solvedPuzzle) {
        unsolvedKillerPuzzles.remove(solvedPuzzle);
    }

    public void increaseWins() {
        wins ++;
    }

    public void increaseLoses() {
        losses ++;
    }

    public String toString() {
        return name + "-" + unsolvedClassicPuzzles + "-" + unsolvedKillerPuzzles + "-" + wins + "-" + losses;
    }
}
