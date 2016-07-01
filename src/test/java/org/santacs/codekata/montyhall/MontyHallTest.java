package org.santacs.codekata.montyhall;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiConsumer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class MontyHallTest {

    @Test
    public void doorCannotBeRevealedWhenItIsChosen() throws Exception {
        Door aDoor = new Door(Prize.Goat);
        aDoor.choose();
        assertFalse(aDoor.isRevealable());
    }

    @Test
    public void doorCannotBeChosenAfterItIsRevealed() throws Exception {
        Door aDoor = new Door(Prize.Goat);
        aDoor.reveal();
        assertFalse(aDoor.isChoosable());
    }

    @Test
    public void contestantSticksWithTheSameDoor() throws Exception {
        firstAndFinalPrizeShould(Assert::assertEquals, new Contestant());
    }

    @Test
    public void trickyContestantSwitchesToTheOtherDoor() throws Exception {
        firstAndFinalPrizeShould(Assert::assertNotEquals, new TrickyContestant());
    }

    @Test
    public void contestantReceivesPrizeFromGameShowHost() throws Exception {
        Contestant aContestant = new Contestant();
        new GameShowHost().playGameWith(aContestant);
        assertNotNull(aContestant.winning());
    }

    private void firstAndFinalPrizeShould(BiConsumer<Prize, Prize> assertion, Contestant aContestant) {
        GameShow aGameShow = GameShow.withShuffledDoors();
        aContestant.chooseDoorOn(aGameShow);
        Prize firstPrize = aGameShow.openChosenDoor();
        aGameShow.revealGoat();
        aContestant.reconsiderTheChoiceOfDoorsOn(aGameShow);
        Prize finalPrize = aGameShow.openChosenDoor();
        assertion.accept(firstPrize, finalPrize);
    }

}
