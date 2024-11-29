package battleShip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Battle {

    private String name;
    private int capacity;
    private List<Ship> ships;

    public Battle(String name, int capacity) {
        this.setName(name);
        this.setCapacity(capacity);
        this.ships = new ArrayList<>();
    }

    public List<Ship> getShips() {
        return Collections.unmodifiableList(this.ships);
    }

    public void addShip(Ship ship) {
        if (ship == null) {
            throw new IllegalArgumentException("Ship can't be null");
        }

        if (ships.size() == this.getCapacity()) {
            throw new IllegalArgumentException("No more places!");
        }
        boolean shipExist = this.ships
                .stream()
                .anyMatch(a -> a.getName().equals(ship.getName()));

        if (shipExist) {
            throw new IllegalArgumentException(String.format("The ship %s already exist!", ship.getName()));
        }

        this.ships.add(ship);
    }


    public boolean removeShip(String shipType) {
        Ship ship = this.ships
                .stream()
                .filter(a -> a.getType().equals(shipType))
                .findFirst()
                .orElse(null);

        return this.ships.remove(ship);
    }

    public String getMostPowerfulShip() {
        Ship ship = ships
                .stream()
                .max(Comparator.comparingInt(Ship::getHitStrength))
                .orElse(null);

        assert ship != null;
        return ship.getName();
    }

    public int getCount() {
        return this.ships.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity!");
        }
        this.capacity = capacity;
    }


    public void setName(String name) {
        this.name = name;
    }

    public List<Ship> findAllShipByAmmunitionMoreThan100() {
        return this.ships.stream().filter(s -> s.getAmmunition() > 100).collect(Collectors.toList());
    }
}