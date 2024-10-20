import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                                    .collect(Collectors.toList());

        String line = scanner.nextLine();
        Map<String, Predicate<String>> predicateMap = new HashMap<>();
        Predicate<String> predicate;

        while (!"Print".equals(line)) {
            String[] tokens = line.split(";");
            String command = tokens[0];
            String type = tokens[1];
            String parameter = tokens[2];
            String predicateName = tokens[1] + ";" + tokens[2];

            switch (command) {
                case "Add filter":
                    //"Starts with", "Ends with", "Length", and "Contains"
                    switch (type) {
                        case "Starts with":
                            predicate = s -> s.startsWith(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                            break;
                        case "Ends with":
                            predicate = s -> s.endsWith(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                            break;
                        case "Length":
                            predicate = s -> s.length() == Integer.parseInt(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                            break;
                        case "Contains":
                            predicate = s -> s.contains(parameter);
                            predicateMap.putIfAbsent(predicateName, predicate);
                            break;
                    }
                    break;
                case "Remove filter":
                    predicateMap.remove(predicateName);
                    break;
            }

            line = scanner.nextLine();
        }

        for (String key : predicateMap.keySet()) {
            Predicate<String> predicate1 = predicateMap.get(key);
//            guests = guests.stream()
//                           .filter(predicate1.negate())
//                           .collect(Collectors.toList());

            guests.removeIf(predicate1);
        }

        guests.forEach(guest -> System.out.print(guest + " "));

    }
}
