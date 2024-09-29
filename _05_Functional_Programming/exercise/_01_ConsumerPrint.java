import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01_ConsumerPrint {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> print = string -> System.out.println(string);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(print);
    }
}
