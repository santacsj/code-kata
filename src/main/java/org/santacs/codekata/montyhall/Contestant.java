package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class Contestant {

    private Prize prize;

    public void chooseADoorOn(GameSet gameSet) {
        gameSet.chooseARandomDoor();
    }

    public void reconsiderItsChoiceOfDoorsOn(GameSet gameSet) {
        // do nothing
    }

    public void receive(Prize prize) { this.prize = prize; }

    public Prize winning() {
        return prize;
    }
}
