package _03_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCostPerKm;
    private int traveledDistance;

    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.traveledDistance = 0;
    }

    // check whether the car can travel the distance
    public boolean canMove(int distance) {
        return this.fuelAmount >= calculateNeededFuel(distance);
    }

    // increase distance
    public void increaseDistance(int distance) {
        this.traveledDistance += distance;
    }

    // decrease fuel
    public void decreaseFuel(int distance) {
        double neededFuel = calculateNeededFuel(distance);
        this.fuelAmount -= neededFuel;
    }

    private double calculateNeededFuel(int distance) {
        return this.fuelCostPerKm * distance;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.traveledDistance);
    }
}
