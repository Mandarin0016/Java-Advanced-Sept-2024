import java.util.Arrays;

public class Main01 {

    public static void main(String[] args) {


        for (Month month : Month.values()) {
            System.out.println(month.ordinal() + " -> " + month + ". Average temperature: " + month.getAverageTemperature());
        }
    }

    public static void printMonth(Month month) {

        System.out.println("This month is " + month);
    }
}
