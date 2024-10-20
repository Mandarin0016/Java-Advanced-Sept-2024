import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());

        Collections.reverse(numbers);

        int n = Integer.parseInt(scanner.nextLine());

        // removes elements that are divisible by a given integer n
        Predicate<Integer> isNotDivisibleByN = number -> number % n != 0;

        Consumer<Integer> print = number -> System.out.print(number + " ");

        numbers.stream()
               .filter(isNotDivisibleByN)
               .forEach(print);
    }
}
