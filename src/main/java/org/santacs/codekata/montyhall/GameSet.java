package org.santacs.codekata.montyhall;

import java.util.*;

/**
 * Created by santacs on 29/06/16.
 */
public class GameSet {

    public static GameSet withShuffledDoors() {
        List<Door> doors = Arrays.asList(new Door(Prize.Goat), new Door(Prize.Goat), new Door(Prize.Car));
        Collections.shuffle(doors);
        return new GameSet(doors);
    }

    private final List<Door> doors;

    public GameSet(Collection<Door> doors) {
        this.doors = new ArrayList<>(doors);
    }

    public void chooseARandomDoor() {
        choose(aRandomDoor());
    }

    private void choose(int door) {
        chosenDoor().ifPresent(Door::unchoose);
        doors.get(door).choose();
    }

    private Optional<Door> chosenDoor() {
        return doors.stream().filter(Door::isChosen).findAny();
    }

    private int aRandomDoor() {
        return new Random().nextInt(doors.size());
    }

    public void revealGoat() {
        doors.stream().filter(Door::isRevealable).findAny().ifPresent(Door::reveal);
    }

    public Prize openChosenDoor() {
        return open(chosenDoor());
    }

    private Prize open(Optional<Door> door) {
        return door.map(Door::open).orElse(null);
    }

    public void chooseOtherDoor() {
        choose(otherDoor());
    }

    private void choose(Door door) {
        choose(doors.indexOf(door));
    }

    private Door otherDoor() {
        return doors.stream().filter(Door::isChoosable).findAny().get();
    }
}
