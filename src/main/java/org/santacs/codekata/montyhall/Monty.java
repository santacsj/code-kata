package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class Monty {

    private final GameSet gameSet;

    public Monty() {
        this(GameSet.withShuffledDoors());
    }

    public Monty(GameSet gameSet) {
        this.gameSet = gameSet;
    }

    public void playWith(Contestant contestant) {
        contestant.chooseADoorOn(gameSet);
        gameSet.revealGoat();
        contestant.reconsiderItsChoiceOfDoorsOn(gameSet);
        Prize prize = gameSet.openChosenDoor();
        contestant.receive(prize);
    }
}
