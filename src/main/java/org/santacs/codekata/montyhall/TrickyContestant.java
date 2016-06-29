package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class TrickyContestant extends Contestant {

    @Override
    public void reconsiderItsChoiceOfDoorsOn(GameSet gameSet) {
        gameSet.chooseOtherDoor();
    }
}
