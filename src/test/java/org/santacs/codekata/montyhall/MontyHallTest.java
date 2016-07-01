package org.santacs.codekata.montyhall;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static org.junit.Assert.*;

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
    public void gameShowShouldChooseOneDoorOnly() throws Exception {
        Door car = new Door(Prize.Car), otherCar = new Door(Prize.Car);
        GameShow aGameShow = new GameShow(car, otherCar);
        aGameShow.choose(car);
        assertTrue(!car.isChoosable() & otherCar.isChoosable());
        aGameShow.choose(otherCar);
        assertTrue(car.isChoosable() & !otherCar.isChoosable());
    }

    @Test
    public void gameShowShouldOpenChosenDoor() throws Exception {
        Door goat = new Door(Prize.Goat);
        GameShow aGameShow = new GameShow(goat);
        aGameShow.choose(goat);
        assertEquals(goat.open(), aGameShow.openChosenDoor());
    }

    @Test
    public void gameShowShouldChooseARandomDoor() throws Exception {
        List<Door> doors = Arrays.asList(new Door(Prize.Goat), new Door(Prize.Car));
        GameShow aGameShow = new GameShow(doors);
        aGameShow.chooseRandomDoor();
        assertEquals(doors.size() - 1, doors.stream().filter(Door::isChoosable).count());
    }

    @Test
    public void gameShowShouldReveaGoat() throws Exception {
        Door goat = new Door(Prize.Goat), otherGoat = new Door(Prize.Goat);
        GameShow aGameShow = new GameShow(goat, otherGoat);
        aGameShow.choose(goat);
        aGameShow.revealGoat();
        assertFalse(otherGoat.isChoosable());
    }

    @Test
    public void gameShowShouldChooseOtherDoor() throws Exception {
        Door goat = new Door(Prize.Goat), otherGoat = new Door(Prize.Goat), car = new Door(Prize.Car);
        GameShow aGameShow = new GameShow(Arrays.asList(goat, otherGoat, car));
        aGameShow.choose(goat);
        aGameShow.revealGoat();
        aGameShow.chooseOtherDoor();
        assertEquals(car.open(), aGameShow.openChosenDoor());
    }

    @Test
    public void contestantSticksWithTheSameDoor() throws Exception {
        firstAndFinalPrizeShould(Assert::assertEquals).accept(new Contestant());
    }

    @Test
    public void trickyContestantSwitchesToTheOtherDoor() throws Exception {
        firstAndFinalPrizeShould(Assert::assertNotEquals).accept(new TrickyContestant());
    }

    @Test
    public void contestantReceivesPrizeFromGameShowHost() throws Exception {
        Contestant aContestant = new Contestant();
        new GameShowHost().playGameWith(aContestant);
        assertNotNull(aContestant.winning());
    }

    private Consumer<Contestant> firstAndFinalPrizeShould(BiConsumer<Prize, Prize> assertion) {
        return aContestant ->
            {
                GameShow aGameShow = GameShow.newStandardGame();
                aContestant.chooseDoorOn(aGameShow);
                Prize firstPrize = aGameShow.openChosenDoor();
                aGameShow.revealGoat();
                aContestant.reconsiderTheChoiceOfDoorsOn(aGameShow);
                Prize finalPrize = aGameShow.openChosenDoor();
                assertion.accept(firstPrize, finalPrize);
            };
    }

}
