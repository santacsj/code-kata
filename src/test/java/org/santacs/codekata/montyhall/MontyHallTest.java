package org.santacs.codekata.montyhall;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MontyHallTest {

    @Test
    public void doorCannotBeChosenAfterItIsRevealed() throws Exception {
        Door aDoor = new Door(Prize.Goat);
        aDoor.reveal();
        assertFalse(aDoor.isChoosable());
    }

    @Test
    public void contestantReceivesPrizeFromGameShowHost() throws Exception {
        GameShowHost aGameShowHost = new GameShowHost();
        Contestant aContestant = new Contestant();
        aGameShowHost.playGameWith(aContestant);
        assertNotNull(aContestant.winning());
    }

    @Test
    public void contestantSticksWithTheSameDoor() throws Exception {
        GameShow aGameShow = GameShow.withShuffledDoors();
        Contestant aContestant = new Contestant();
        aContestant.chooseDoorOn(aGameShow);
        Prize previousPrize = aGameShow.openChosenDoor();
        aGameShow.revealGoat();
        aContestant.reconsiderTheChoiceOfDoorsOn(aGameShow);
        assertEquals(previousPrize, aGameShow.openChosenDoor());
    }

    @Test
    public void trickyContestantSwitchesToTheOtherDoor() throws Exception {
        GameShow aGameShow = GameShow.withShuffledDoors();
        Contestant aTrickyContestant = new TrickyContestant();
        aTrickyContestant.chooseDoorOn(aGameShow);
        Prize previousPrize = aGameShow.openChosenDoor();
        aGameShow.revealGoat();
        aTrickyContestant.reconsiderTheChoiceOfDoorsOn(aGameShow);
        assertNotEquals(previousPrize, aGameShow.openChosenDoor());
    }

    @Test
    public void testAssumptions() throws Exception {
        System.out.printf("Stick Win %%: %f%n", calculateWinPercentFor(new Contestant()));
        System.out.printf("Switch Win %%: %f%n", calculateWinPercentFor(new TrickyContestant()));
    }

    private double calculateWinPercentFor(Contestant contestant) {
        return IntStream.range(0, 1000)
                .mapToObj(round -> playARoundWith(contestant))
                .filter(Prize.Car::equals)
                .count() / 1000f * 100;
    }

    private Prize playARoundWith(Contestant contestant) {
        GameShowHost gameShowHost = new GameShowHost();
        gameShowHost.playGameWith(contestant);
        return contestant.winning();
    }
}
