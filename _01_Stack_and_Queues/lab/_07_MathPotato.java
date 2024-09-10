import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class _07_MathPotato {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> kids = new PriorityQueue<>();
        String[] kidsNames = scanner.nextLine().split("\\s+");

        Collections.addAll(kids, kidsNames);

        int n = Integer.parseInt(scanner.nextLine());

        int rotations = 0;
        while (kids.size() > 1) {

            // 1. Вземам първото дете от опашката
            String kid = kids.poll();
            // 2. Увеличавам rotations + 1
            rotations++;
            if (isPrime(rotations)) {
                System.out.println("Prime " + kid);
                kids.offer(kid);
            } else {
                System.out.println("Removed " + kid);
            }
        }

        System.out.println("Last is " + kids.poll());
    }

    private static boolean isPrime(int number) {

        if (number == 1) {
            return false;
        }

        boolean isPrime = true;

        // Прости числа: делят се целочислено без остатък на 1 и себе си!
        // Непрости числа: Търсим още един делител
        for (int divisor = 2; divisor <= number - 1; divisor++) {
            // Има друг възможен делител!
            if (number % divisor == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
