package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class GameShowHost {

    private final GameShow gameShow;

    public GameShowHost() {
        this(GameShow.withShuffledDoors());
    }

    public GameShowHost(GameShow gameShow) {
        this.gameShow = gameShow;
    }

    public void playGameWith(Contestant contestant) {
        contestant.chooseDoorOn(gameShow);
        gameShow.revealGoat();
        contestant.reconsiderTheChoiceOfDoorsOn(gameShow);
        Prize prize = gameShow.openChosenDoor();
        contestant.receive(prize);
    }
}
