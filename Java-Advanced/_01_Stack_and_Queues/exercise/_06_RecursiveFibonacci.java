import java.util.Scanner;

public class _06_RecursiveFibonacci {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n + 1];
        long result = fib(n);

        System.out.println(result);
    }

    private static long fib(int n) {

        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        memory[n] = fib(n - 1) + fib(n - 2);

        return memory[n];
    }

    /*
            fib(7) = fib(6) + fib(5)
            fib(6) = fib(5) + fib(4)
            fib(5) = fib(4) + fib(3)
            fib(4) = fib(3) + fib(2)
            fib(3) = fib(2) + fib(1)
            fib(2) = fib(1) + fib(0)
            fib(1) = 1
            fib(0) = 0

     */
}
