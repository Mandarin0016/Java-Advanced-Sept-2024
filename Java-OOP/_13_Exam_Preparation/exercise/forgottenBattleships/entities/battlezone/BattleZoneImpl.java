package forgottenBattleships.entities.battlezone;

import java.util.ArrayList;
import java.util.Collection;

import forgottenBattleships.entities.battleship.Battleship;

import static forgottenBattleships.common.ExceptionMessages.*;

public class BattleZoneImpl implements BattleZone {

    private String name;
    private int capacity;
    private Collection<Battleship> ships;

    public BattleZoneImpl(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.ships = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(BATTLE_ZONE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addBattleship(Battleship ship) {

        if (this.capacity <= this.ships.size()) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }

        if (ship.getHealth() <= 0) {
            throw new IllegalArgumentException(SHIP_HEALTH_NULL_OR_EMPTY);
        }

        this.ships.add(ship);
    }

    @Override
    public Battleship getBattleshipByName(String battleshipName) {
        return this.ships.stream()
                         .filter(ship -> ship.getName().equals(battleshipName))
                         .findFirst()
                         .orElse(null);
    }

    @Override
    public void removeBattleShip(Battleship ship) {
        this.ships.remove(ship);
    }

    @Override
    public Collection<Battleship> getShips() {
        return this.ships;
    }
}
