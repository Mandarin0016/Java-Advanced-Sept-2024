package _01_Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        String line = scanner.nextLine();
        //        List<Birthable> birthables = new ArrayList<>();
        //        while (!"End".equals(line)) {
        //            String[] tokens = line.split("\\s+");
        //
        //            switch (tokens[0]) {
        //                case "Citizen" -> {
        //                    Citizen citizen = new Citizen(tokens[1],
        //                                                  Integer.parseInt(tokens[2]),
        //                                                  tokens[3],
        //                                                  tokens[4]);
        //                    birthables.add(citizen);
        //                }
        //                case "Pet" -> {
        //                    Pet pet = new Pet(tokens[1], tokens[2]);
        //                    birthables.add(pet);
        //                }
        //            }
        //
        //            line = scanner.nextLine();
        //        }
        //
        //        String year = scanner.nextLine();
        //
        //        birthables.stream()
        //                  .filter(birthable -> birthable.getBirthDate().endsWith(year))
        //                  .forEach(birthable -> System.out.println(birthable.getBirthDate()));

        Map<String, Buyer> buyers = new HashMap();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            String age = tokens[1];

            if (tokens.length == 3) {
                String group = tokens[2];
                Rebel rebel = new Rebel(name, Integer.parseInt(age), group);
                buyers.putIfAbsent(name, rebel);
            } else {
                String id = tokens[2];
                String birthDate = tokens[3];
                Citizen citizen = new Citizen(name, Integer.parseInt(age), id, birthDate);
                buyers.putIfAbsent(name, citizen);
            }
        }

        String buyer = scanner.nextLine();

        while (!"End".equals(buyer)) {
            Buyer buyer1 = buyers.get(buyer);

            if (buyer1 != null) {
                buyer1.buyFood();
            }

            buyer = scanner.nextLine();
        }

        int totalFood = buyers.values()
                              .stream()
                              .mapToInt(Buyer::getFood)
                              .sum();

        System.out.println(totalFood);
    }
}
