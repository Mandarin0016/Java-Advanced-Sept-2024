import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        // 5! = 5 * 4 * 3 * 2 * 1
        // 4! = 4 * 3 * 2 * 1
        // 3! = 3 * 2 * 1
        // n! = n * (n-1)!

        // 5! = 5 * 4!
        // 4! = 4 * 3!
        // 3! = 3 * 2!
        // 2! = 2 * 1!
        // 1! (дъно на рекурсията)

        // 0! = 1
        // 1! = 1

        System.out.println(calcFactorial(n));

    }

    public static long calcFactorial(long number) {

        // Дъно на рекурсията
        if (number == 1) {
            return 1;
        }

        // Рекурсия
        long result = number * calcFactorial(number - 1);

        return result;
    }
}
