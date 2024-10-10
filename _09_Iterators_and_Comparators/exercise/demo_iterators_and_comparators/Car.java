package demo_iterators_and_comparators;

public class Car implements Comparable<Car> {

    private String model;
    private int horsePower;
    private String makeYear; // 4 digits
    private String vin;

    public Car(String model, int horsePower, String... args) {
        this.model = model;
        this.horsePower = horsePower;

        if (args.length == 1) {
            if (args[0].length() == 4) {
                this.makeYear = args[0];
            } else {
                this.vin = args[0];
            }
        } else if (args.length == 2) {
            if (args[0].length() == 4) {
                this.makeYear = args[0];
                this.vin = args[1];
            } else {
                this.makeYear = args[1];
                this.vin = args[0];
            }
        }

    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String getMakeYear() {
        return makeYear;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public int compareTo(Car car) {
        /*
           this.car < car -> -1
           this.car > car -> 1
           this.car == car -> 0
         */

        if (this.horsePower == car.horsePower) {
            return 0;
        } else if (this.horsePower > car.horsePower) {
            return 1;
        }

        return -1;
    }

    @Override
    public String toString() {
        return "demo.Car{" +
               "model='" + model + '\'' +
               ", horsePower=" + horsePower +
               ", makeYear='" + makeYear + '\'' +
               ", vin='" + vin + '\'' +
               '}';
    }
}
