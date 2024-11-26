package prototype;

public class SportCar extends Car {

    public SportCar(String model, int horsePower) {
        super(model, horsePower);
    }

    @Override
    Car copy() {
        SportCar sportCarClone = new SportCar(super.getModel(), super.getHorsePower());
        return sportCarClone;
    }
}
