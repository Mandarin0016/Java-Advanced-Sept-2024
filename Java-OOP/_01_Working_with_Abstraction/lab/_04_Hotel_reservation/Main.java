package _04_Hotel_reservation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //The price per day will be a valid decimal in the range [0.01…1000.00].
        //The number of days will be a valid integer in the range [1…1000].
        //The season will be one of Spring, Summer, Autumn, Winter.
        //The discount will be one of VIP, SecondVisit, None.

        String[] data = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(data[0]);
        int numberOfDays = Integer.parseInt(data[1]);
        Season season = Season.valueOf(data[2]);
        Discount discount = Discount.valueOf(data[3]);

        System.out.printf("%.2f", PriceCalculator.calculatePrice(pricePerDay, numberOfDays, season, discount));
    }
}
