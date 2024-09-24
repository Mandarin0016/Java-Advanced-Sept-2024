import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Predicate<String> startWithUppercase = word -> Character.isUpperCase(word.charAt(0));
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).filter(startWithUppercase).toList();

        System.out.println(words.size());
        words.forEach(word -> System.out.println(word));
    }
}
