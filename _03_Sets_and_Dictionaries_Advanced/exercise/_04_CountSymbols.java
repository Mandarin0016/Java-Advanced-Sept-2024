import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> dictionary = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            dictionary.putIfAbsent(currentChar, 0);
            dictionary.put(currentChar, dictionary.get(currentChar) + 1);
            //            if (dictionary.containsKey(currentChar)) {
            //                Integer currentValue = dictionary.get(currentChar);
            //                dictionary.put(currentChar, currentValue + 1);
            //            } else {
            //                dictionary.put(currentChar, 1);
            //            }
        }

        dictionary.forEach((key, value) ->
                           System.out.printf("%c: %d time/s\n", key, value)
                          );
    }
}
