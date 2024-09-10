import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int inputNumber = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> binaryStack = new ArrayDeque<>();

        if (inputNumber == 0) {
            System.out.println(inputNumber);
        } else {
            while (inputNumber != 0) {
                binaryStack.push(inputNumber % 2);
                inputNumber /= 2;
            }
        }

        for (Integer num : binaryStack) {
            System.out.print(num);
        }
    }
}
