package _03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);

            Car car = new Car(carModel, fuelAmount, fuelCostPerKm);
            cars.putIfAbsent(carModel, car);
        }

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            String[] tokens = line.split("\\s+");
            String carModel = tokens[1];
            int distance = Integer.parseInt(tokens[2]);

            Car car = cars.get(carModel);

            if (car.canMove(distance)){
                car.decreaseFuel(distance);
                car.increaseDistance(distance);
            }else {
                System.out.println("Insufficient fuel for the drive");
            }

            line = scanner.nextLine();
        }

        cars.values()
            .forEach(System.out::println);
    }
}
