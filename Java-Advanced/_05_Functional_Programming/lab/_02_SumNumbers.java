import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class _02_SumNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).toList();

        // 1. брой числа в списъка
        int numbersCount = numbers.size();

        // 2. сумата на числата в списъка
        Function<List<Integer>, Integer> sumNumbers = numbersList -> {
            int sum = 0;
            for (Integer num : numbersList) {
                sum += num;
            }
            return sum;
        };

        System.out.println("Count = " + numbersCount);
        System.out.println("Sum = " + sumNumbers.apply(numbers));
    }
}
