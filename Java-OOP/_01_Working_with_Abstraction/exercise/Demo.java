import java.util.Arrays;
import java.util.EnumMap;

public class Demo {

    private static final String APRIL = "APRIL";

    public static void main(String[] args) {

        //        Arrays.stream(Calendar.values())
        //              .forEach(System.out::println);
        Calendar.printMonths();
        System.out.println(Calendar.JANUARY.calculateMonthSalary(56));
    }
}
