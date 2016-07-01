package org.santacs.codekata.montyhall;

import java.util.*;

/**
 * Created by santacs on 29/06/16.
 */
public class GameShow {

    public static GameShow newStandardGame() {
        List<Door> doors = Arrays.asList(new Door(Prize.Goat), new Door(Prize.Goat), new Door(Prize.Car));
        Collections.shuffle(doors);
        return new GameShow(doors);
    }

    private final List<Door> doors;
    private Door chosen;

    public GameShow(Collection<Door> doors) {
        this.doors = new ArrayList<>(doors);
    }

    public void chooseRandomDoor() {
        choose(get(aRandomDoor()));
    }

    protected Optional<Door> chosenDoor() {
        return Optional.ofNullable(chosen);
    }

    protected void choose(Door door) {
        chosenDoor().ifPresent(Door::unchoose);
        door.choose();
        chosen = door;
    }

    protected Door get(int door) {
        return doors.get(door);
    }

    protected int aRandomDoor() {
        return new Random().nextInt(doors.size());
    }

    public void revealGoat() {
        doors.stream().filter(Door::isRevealable).findAny().ifPresent(Door::reveal);
    }

    public Prize openChosenDoor() {
        return chosenDoor().map(Door::open).orElse(null);
    }

    public void chooseOtherDoor() {
        choose(doors.stream().filter(Door::isChoosable).findAny().get());
    }

}
