import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //IN, CA1234TA
        //OUT, CA2844AA
        //END

        Set<String> carNumbers = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }

            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNumber : carNumbers) {
                System.out.println(carNumber);
            }
        }
    }
}
