import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();
        //5
        //Peter, 20
        //George, 18
        //Maria, 29
        //Idan, 31
        //Simeon, 16

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String name = line.split(", ")[0];
            int age = Integer.parseInt(line.split(", ")[1]);
            people.put(name, age);
        }

        //Condition - "younger" or "older"
        //Age - Integer
        //Format - "name", "age" or "name age"

        String condition = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> agePredicate;
        if (condition.equals("younger")) {
            agePredicate = personAge -> personAge <= ageLimit;
        } else {
            agePredicate = personAge -> personAge >= ageLimit;
        }

        Consumer<Map.Entry<String, Integer>> print;
        if (format.equals("name")) {
            print = entry -> System.out.println(entry.getKey());
        } else if (format.equals("age")) {
            print = entry -> System.out.println(entry.getValue());
        } else {
            print = entry -> System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
        }

        // 1:
        people.entrySet()
                .stream()
                .filter(entry -> agePredicate.test(entry.getValue()))
                .forEach(print);

        // 2:
//        for (Map.Entry<String, Integer> entry : people.entrySet()) {
//            if (agePredicate.test(entry.getValue())){
//                print.accept(entry);
//            }
//        }
    }
}
