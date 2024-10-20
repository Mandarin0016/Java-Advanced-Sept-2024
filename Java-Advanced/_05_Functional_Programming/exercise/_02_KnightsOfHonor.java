import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _02_KnightsOfHonor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> appendSirAndPrint = string ->
                                     System.out.println("Sir " + string);

        Arrays.stream(scanner.nextLine().split("\\s+"))
              .forEach(appendSirAndPrint);

    }
}
