package LOGIC.FILE_MANAGEMENT;

import java.io.Serializable;
import java.util.ArrayList;

public class Entry implements Serializable {
    private String name;
    private ArrayList<Integer> unsolvedPuzzles;
    private int wins;
    private int losses;
    //constructor
    public Entry(String name){
        this.name = name;
        unsolvedPuzzles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            unsolvedPuzzles.add(i);
        }
        wins = losses = 0;
    }
    //-------------------------------------------
    public void setName(String name) {
        this.name = name;
    }

    public void setUnsolvedPuzzles(ArrayList<Integer> unsolvedPuzzles) {
        this.unsolvedPuzzles = unsolvedPuzzles;
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

    public ArrayList<Integer> getUnsolvedPuzzles() {
        return unsolvedPuzzles;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
    //------------------------------------------

    public void puzzleSolved(int solvedPuzzle) {
        unsolvedPuzzles.remove(solvedPuzzle);
    }

    public String toString() {
        return name + "-" + unsolvedPuzzles + "-" + wins + "-" + losses;
    }
}
