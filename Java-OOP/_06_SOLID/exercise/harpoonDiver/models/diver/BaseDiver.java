package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

import static harpoonDiver.common.ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY;
import static harpoonDiver.common.ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseDiver implements Diver {

    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public void shoot() {
        // • The method decreases the diver's oxygen by 30 units.
        this.oxygen -= 30;

        // • The oxygen value should not drop below zero.
        // • Set the value to be zero if the oxygen value drops below zero
        if (this.oxygen < 0) {
            this.oxygen = 0;
        }
    }

    @Override
    public boolean canDive() {
        return this.oxygen > 0;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(DIVER_OXYGEN_LESS_THAN_ZERO);
        }

        this.oxygen = oxygen;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return seaCatch;
    }

    public void setSeaCatch(SeaCatch seaCatch) {
        this.seaCatch = seaCatch;
    }
}
