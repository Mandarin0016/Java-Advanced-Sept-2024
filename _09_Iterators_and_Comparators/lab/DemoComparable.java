import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class DemoComparable {

    public static void main(String[] args) {

        Cat cat1 = new Cat("Asparuhcho", 7, 15.0);
        Cat cat2 = new Cat("Ivancho", 5, 7.0);
        Cat cat3 = new Cat("Ivancho", 1, 8.0);

        List<Cat> cats = Arrays.asList(cat1, cat2, cat3);

        Collections.sort(cats);

        TreeSet<Cat> cats1 = new TreeSet<>();

        //проверявам дали адресите в паметта на двата обекта са равни
        cat1.equals(cat2);

    }
}
