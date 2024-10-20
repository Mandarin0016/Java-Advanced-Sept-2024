import java.util.Map;
import java.util.Set;

public class Country {

    private String name;
    // city   population
    private Map<String, Long> cities; // Set<City>, City -> name, population

    public Country(String name, Map<String, Long> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public Map<String, Long> getCities() {
        return cities;
    }

    public long getTotalPopulation() {
        return cities.values()
                     .stream()
                     .mapToLong(Long::longValue)
                     .sum();
    }

    // Print cities by population in descending order
    public void printCities(){
        cities.entrySet()
              .stream()
              .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
              .forEach(cityEntry ->
                       System.out.printf("=>%s: %d\n",
                                         cityEntry.getKey(),
                                         cityEntry.getValue())
                      );
    }
}
