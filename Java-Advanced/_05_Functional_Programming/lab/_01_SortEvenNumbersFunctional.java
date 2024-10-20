import java.util.*;
import java.util.stream.Collectors;

public class _01_SortEvenNumbersFunctional {

    public static void main(String[] args) {

        // Функционален стил (lambda expressions)
        Scanner scanner = new Scanner(System.in);

        //[4, 2, 1, 3, 5, 7, 1, 4, 2, 12]
        List<Integer> evenNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(text -> Integer.parseInt(text)) // преобразувам всеки текст към число ("5" -> 5)
                .filter(number -> number % 2 == 0) // проверявам всяко число от поредицата с числа дали е четно
                .collect(Collectors.toList());

        System.out.println(evenNumbers.toString().replaceAll("\\[", "").replaceAll("]", ""));
        Collections.sort(evenNumbers);
        System.out.println(evenNumbers.toString().replaceAll("\\[", "").replaceAll("]", ""));
    }
}
