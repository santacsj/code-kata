package org.santacs.codekata.montyhall;

/**
 * Created by santacs on 29/06/16.
 */
public class TrickyContestant extends Contestant {

    @Override
    public void reconsiderTheChoiceOfDoorsOn(GameShow gameShow) {
        gameShow.chooseOtherDoor();
    }
}
