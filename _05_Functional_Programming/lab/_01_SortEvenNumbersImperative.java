import java.util.*;

public class _01_SortEvenNumbersImperative {

    public static void main(String[] args) {

        // Императивен стил (стъпки и ясни блокове от код for, if, switch)
        Scanner scanner = new Scanner(System.in);

        //[4, 2, 1, 3, 5, 7, 1, 4, 2, 12]
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(text -> Integer.parseInt(text)).toList();
        List<Integer> evenNumbers = new ArrayList<>();

        // Стъпка 1:
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }

        //Print the even numbers.
        printEvenNumbers(evenNumbers);

        //Sort them in ascending order.
        Collections.sort(evenNumbers);

        //Print them again.
        printEvenNumbers(evenNumbers);
    }

    private static void printEvenNumbers(List<Integer> evenNumbers) {
        for (Integer evenNumber : evenNumbers) {
            System.out.print(evenNumber + " ");
        }
        System.out.println();
    }
}
