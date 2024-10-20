import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainLab05 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // "5 6 7"
        // .split(" ") -> ["5", "6", "7"]
        // JS: text => Integer.parseInt(text)
        // Java: text -> Integer.parseInt(text)
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();

        int number = 5;
        System.out.println(number);

        // Function<приема, връща> (връща резултат)                        | .apply(аргумент)
        // Consumer<приема> (НЕ връща резултат)                            | .accept(аргумент)
        // Supplier<връща> (НЕ приема аргумент, но пък връща резултат)     | .get()
        // Predicate<приема> (връща булева стойност)                       | .test(аргумент)

        LocalDateTime today = LocalDateTime.now();

        if (today.getMonth() == Month.SEPTEMBER && today.getDayOfMonth() == 24) {
            System.out.println("Hey, Yani! Today is 24th September and time is + " + today.getHour() + ":" + today.getMinute() + ":" + today.getSecond());
        }

    }
}
