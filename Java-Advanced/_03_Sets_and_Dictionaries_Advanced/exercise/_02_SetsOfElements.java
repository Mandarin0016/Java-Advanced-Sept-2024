import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = Integer.parseInt(scanner.nextLine());

        Set<String> firstSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            firstSet.add(scanner.nextLine());
        }

        Set<String> secondSet = new LinkedHashSet<>();
        for (int i = 0; i < m; i++) {
            secondSet.add(scanner.nextLine());
        }

        firstSet.retainAll(secondSet);

        String result = String.join(" ", firstSet);
        System.out.println(result);
    }
}
