package _01_vehicle;

public class Truck extends VehicleImpl {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + 1.6, tankCapacity);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
