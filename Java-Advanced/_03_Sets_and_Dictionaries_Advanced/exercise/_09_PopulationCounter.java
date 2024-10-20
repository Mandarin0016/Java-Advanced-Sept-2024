import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _09_PopulationCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Long>> countries = new LinkedHashMap<>();
        Map<String, Long> countriesTotalPopulationMap = new LinkedHashMap<>();
        while (!"report".equals(line)) {
            // "city|country|population".
            String[] tokens = line.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            Long population = Long.parseLong(tokens[2]);

            countries.putIfAbsent(country, new HashMap<>());
            countries.get(country).put(city, population);

            countriesTotalPopulationMap.putIfAbsent(country, 0L);
            long totalPopulationToAdd = countriesTotalPopulationMap.get(country) + population;
            countriesTotalPopulationMap.put(country, totalPopulationToAdd);

            line = scanner.nextLine();
        }

        countriesTotalPopulationMap

        .entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .forEach(entry -> {

            System.out.printf("%s (total population: %d)\n", entry.getKey(), entry.getValue());

            Map<String, Long> cities = countries.get(entry.getKey());

            cities.entrySet()
                  .stream()
                  .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                  .forEach(cityEntry ->
                           System.out.printf("=>%s: %d\n",
                                             cityEntry.getKey(),
                                             cityEntry.getValue())
                          );

        });

    }
}
