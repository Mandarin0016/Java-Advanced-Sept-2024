package solid;

import java.util.List;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    private Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public <T extends Product> void printSum(List<T> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public <T extends Product> void printAverage(List<T> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
