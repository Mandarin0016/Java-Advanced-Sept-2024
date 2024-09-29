import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DemoFuncProgramming {

    public static void main(String[] args) {

        //Function<InputParam, ReturnType> -> use with apply
        Function<Integer, Integer> powerOf2Func = (a) -> {
            return a * a;
        };
        //        Integer result = powerOf2Func.apply(5);
        //        System.out.println(result);

        //Consumer<InputParam> -> void -> use with accept
        //        Consumer<Integer> printNumber = a -> System.out.println(a);
        Consumer<Integer> printNumber = System.out::println;
        // printNumber.accept(100);

        //Supplier<ReturnType> -> use with get
        Supplier<Scanner> getScannerSupplier = () -> new Scanner(System.in);
        Scanner scanner = getScannerSupplier.get();

        //Predicate<InputParam> -> return true / false -> use with test
        Predicate<Integer> isEvenPredicate = a -> a % 2 == 0;
        System.out.println(isEvenPredicate.test(25));

        //BiFunction<InputParam1, InputParam2, ReturnType> -> use with apply
        BiFunction<Integer, Integer, Long> multiplyBiFunc = (a, b) -> Long.valueOf(a * b);
        System.out.println(multiplyBiFunc.apply(5, 6));

        // Custom Function
        Calculator customCalculator = (a, b, c) -> {
            Integer[] result = new Integer[2];
            //TODO calculate something
            // ax^2 + bx + c = 0

            return result;
        };

        Integer[] result = customCalculator.calculate(2, 3, 5);


        // 1 2 3 4 5 6 7 8 9 10
        Arrays.stream(getScannerSupplier.get().nextLine().split(" "))
              .map(Integer::parseInt)
              .map(powerOf2Func)
              .filter(isEvenPredicate)
              .forEach(printNumber);
    }

    private static int powerOf2(int a) {
        return a * a;
    }

    private static void print(int a) {
        System.out.println(a);
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    private static int multiply(int a, int b) {
        return a * b;
    }

    @FunctionalInterface
    interface Calculator {

        // input param => a, b, c
        Integer[] calculate(int a, int b, int c);
    }

}
