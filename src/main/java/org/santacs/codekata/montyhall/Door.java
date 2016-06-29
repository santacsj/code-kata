package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class Door {

    private final Prize prize;
    private boolean chosen;
    private boolean revealed;

    public Door(Prize prize) {
        this.prize = prize;
    }

    public Prize open() {
        return prize;
    }

    public void choose() {
        this.chosen = true;
    }

    public void unchoose() {
        this.chosen = false;
    }

    public boolean isChosen() {
        return chosen;
    }

    public void reveal() {
        this.revealed = true;
    }

    public boolean isRevealable() {
        return hidesAGoat() && !isChosen();
    }

    public boolean isChoosable() {
        return !(isChosen() || revealed);
    }

    private boolean hidesAGoat() {
        return Prize.Goat == prize;
    }
}
