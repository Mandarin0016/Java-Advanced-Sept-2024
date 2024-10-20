import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _08_AcademyGraduation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, Double[]> graduationList = new TreeMap<>();

        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            Double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .toArray(Double[]::new);

            graduationList.put(name, scores);
        }

        for (Map.Entry<String, Double[]> entry : graduationList.entrySet()) {

            String name = entry.getKey();
            Double[] grades = entry.getValue();

            System.out.printf("%s is graduated with %s%n", name, getAverageScore(grades));
        }
    }

    private static Double getAverageScore(Double[] values) {
        double average = 0.0;
        for (Double value : values) {
            average += value;
        }
        return average / values.length;
    }
}
