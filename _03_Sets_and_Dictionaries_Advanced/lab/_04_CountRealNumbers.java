import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //-2.5 4 3 -2.5 -5.5 4 3 3 -2.5 3
        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numberOccurrences = new LinkedHashMap<>();
        for (double value : values) {
            // ВАРИАНТ 1:
            if (!numberOccurrences.containsKey(value)) {
                numberOccurrences.put(value, 1);
            } else {
                numberOccurrences.put(value, numberOccurrences.get(value) + 1);
            }

            // ВАРИАНТ 2:
//            numberOccurrences.putIfAbsent(value, 0);
//            numberOccurrences.put(value, numberOccurrences.get(value) + 1);
        }

        //-2.5 -> 3
        //4.0 -> 2
        //3.0 -> 4
        //-5.5 -> 1
        for (Map.Entry<Double, Integer> entry : numberOccurrences.entrySet()) {
            System.out.printf("%.1f -> %d\n", entry.getKey(), entry.getValue());
        }

    }
}
