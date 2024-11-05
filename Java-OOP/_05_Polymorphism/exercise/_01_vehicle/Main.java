package _01_vehicle;

import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Vehicle car = new Car(Double.parseDouble(tokens[1]),
                              Double.parseDouble(tokens[2]),
                              Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");

        Vehicle truck = new Truck(Double.parseDouble(tokens[1]),
                                  Double.parseDouble(tokens[2]),
                                  Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");

        Vehicle bus = new Bus(Double.parseDouble(tokens[1]),
                              Double.parseDouble(tokens[2]),
                              Double.parseDouble(tokens[3]));

        Map<String, Vehicle> vehicleMap = Map.of("Car", car,
                                                 "Truck", truck,
                                                 "Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            tokens = scanner.nextLine().split("\\s+");
            try {
                Vehicle vehicle = vehicleMap.get(tokens[1]);
                double parameter = Double.parseDouble(tokens[2]);
                switch (tokens[0]) {
                    case "Drive" -> {
                        vehicle.setEmpty(false);
                        String result = vehicle.drive(parameter);
                        System.out.println(result);
                    }
                    case "DriveEmpty" -> {
                        vehicle.setEmpty(true);
                        String result = vehicle.drive(parameter);
                        System.out.println(result);
                    }
                    case "Refuel" -> vehicle.refuel(parameter);
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
