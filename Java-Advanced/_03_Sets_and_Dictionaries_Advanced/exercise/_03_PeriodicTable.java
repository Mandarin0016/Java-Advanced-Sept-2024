import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03_PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

//            elements.addAll(Arrays.stream(scanner.nextLine().split("\\s+")).toList());
            Collections.addAll(elements, input);
        }

        String result = String.join(" ", elements);
        System.out.println(result);
    }
}
