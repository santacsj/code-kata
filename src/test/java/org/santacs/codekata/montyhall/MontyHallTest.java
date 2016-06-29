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
    public void contestantReceivesPrizeFromMonty() throws Exception {
        Monty monty = new Monty();
        Contestant aContestant = new Contestant();
        monty.playWith(aContestant);
        assertNotNull(aContestant.winning());
    }

    @Test
    public void contestantSticksWithTheSameDoor() throws Exception {
        GameSet aGameSet = GameSet.withShuffledDoors();
        Contestant aContestant = new Contestant();
        aContestant.chooseADoorOn(aGameSet);
        Prize previousPrize = aGameSet.openChosenDoor();
        aGameSet.revealGoat();
        aContestant.reconsiderItsChoiceOfDoorsOn(aGameSet);
        assertEquals(previousPrize, aGameSet.openChosenDoor());
    }

    @Test
    public void trickyContestantSwitchesToTheOtherDoor() throws Exception {
        GameSet aGameSet = GameSet.withShuffledDoors();
        Contestant aContestant = new TrickyContestant();
        aContestant.chooseADoorOn(aGameSet);
        Prize previousPrize = aGameSet.openChosenDoor();
        aGameSet.revealGoat();
        aContestant.reconsiderItsChoiceOfDoorsOn(aGameSet);
        assertNotEquals(previousPrize, aGameSet.openChosenDoor());
    }

    @Test
    public void testAssumptions() throws Exception {
        System.out.printf("Stick Win %%: %f\n", calculateWinPercentFor(new Contestant()));
        System.out.printf("Switch Win %%: %f\n", calculateWinPercentFor(new TrickyContestant()));
    }

    private double calculateWinPercentFor(Contestant contestant) {
        return IntStream.range(0, 1000)
                .mapToObj(round -> playARoundWith(contestant))
                .filter(Prize.Car::equals)
                .count() / 1000f * 100;
    }

    private Prize playARoundWith(Contestant contestant) {
        Monty monty = new Monty();
        monty.playWith(contestant);
        return contestant.winning();
    }
}
