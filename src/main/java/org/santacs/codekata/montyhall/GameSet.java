package org.santacs.codekata.montyhall;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        chooseDoor(new Random().nextInt(doors.size()));
    }

    private void chooseDoor(int number) {
        chosenDoor().ifPresent(Door::unchoose);
        doors.get(number).choose();
    }

    private Optional<Door> chosenDoor() {
        return doors.stream().filter(Door::isChosen).findAny();
    }

    public void revealGoat() {
        doors.stream().filter(Door::isRevealable).findAny().ifPresent(Door::reveal);
    }

    public Prize openChosenDoor() {
        return chosenDoor().map(Door::open).orElse(null);
    }

    public void chooseOtherDoor() {
        chooseDoor(doors.indexOf(otherDoor()));
    }

    private Door otherDoor() {
        return doors.stream().filter(Door::isChoosable).findAny().get();
    }
}
