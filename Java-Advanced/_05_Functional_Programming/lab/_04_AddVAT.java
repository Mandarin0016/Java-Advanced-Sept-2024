import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AddVAT {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1.38, 2.56, 4.4
        List<Double> prices = Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        Function<Double, Double> vatFunction = price -> price * 1.2;
        Consumer<Double> printPrice = price -> System.out.printf("%.2f\n", price);

        System.out.println("Prices with VAT:");

        // 1:
//        for (Double price : prices) {
//            double priceWithVAT = vatFunction.apply(price);
//            System.out.printf("%.2f\n", priceWithVAT);
//        }

        // 2:
        prices.stream()
                .map(vatFunction)
                .forEach(printPrice);
    }
}
