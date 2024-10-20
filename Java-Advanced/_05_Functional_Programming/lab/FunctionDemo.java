import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {

        // Ламбда израз: приема 1 аргумент и връща 1 резултат
        // Function<приема, връща> | .apply()
        Function<Integer, Integer> func = x -> x * x;

        Integer result1 = func.apply(5);
        Integer result2 = pow(5);

        // Функционален код
        Function<List<Integer>, Integer> sumNumbers = list -> {
            int sum = 0;
            for (Integer num : list) {
                sum += num;
            }
            return sum;
        };

        List<Integer> numbers = List.of(5, 6, 7, 8);
        System.out.println(sumNumbers.apply(numbers));
    }

    public static int pow(int x) {
        return x * x;
    }

    // Императивен код
    public static int sumListNumbers(List<Integer> numbers){
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        return sum;
    }
}
