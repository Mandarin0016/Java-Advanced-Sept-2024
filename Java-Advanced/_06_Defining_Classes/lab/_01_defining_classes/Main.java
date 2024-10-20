package _01_defining_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Списък, в който съхранявам обекти от класа Car
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {

            //["Chevrolet", "Impala", "390"]
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            String model = tokens[1];
            int horsePowers = Integer.parseInt(tokens[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePowers);
            cars.add(car);
        }

        // Започва да обхожда обектите в този списък -> кола по кола
        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
