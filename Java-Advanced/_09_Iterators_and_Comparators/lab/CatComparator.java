import java.util.Comparator;
import java.util.Scanner;

// Компаратора е външен клас, който не променя моят клас и неговата роля е да сравни два обекта от 1 тип.
public class CatComparator implements Comparator<Cat> {

    public int compare(Cat cat1, Cat cat2) {
        return cat1.getName().compareTo(cat2.getName());
    }
}
