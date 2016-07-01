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
        chosen = true;
    }

    public void unchoose() {
        chosen = false;
    }

    public void reveal() {
        revealed = true;
    }

    public boolean isRevealable() {
        return !chosen && Prize.Goat == prize;
    }

    public boolean isChoosable() {
        return !(chosen || revealed);
    }

}
