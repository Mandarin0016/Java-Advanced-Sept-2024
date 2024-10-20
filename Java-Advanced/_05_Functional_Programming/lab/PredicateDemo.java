import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {

        // Ламбда израз, който приема 1 аргумент и връща булев резулатат
        // Predicate<приема> | .test(...)
        Predicate<Integer> isEven = number -> number % 2 == 0;

        Predicate<String> containsLetterS = name -> {
            for (char c : name.toCharArray()) {
                if (c == 'S'){
                    return true;
                }
            }
            return false;
        };

        Predicate<String> startWithS = name -> name.startsWith("S");

        System.out.println(startWithS.test("Stefan"));
        System.out.println(startWithS.test("Ivan"));

        System.out.println(isEven.test(6));
    }
}
