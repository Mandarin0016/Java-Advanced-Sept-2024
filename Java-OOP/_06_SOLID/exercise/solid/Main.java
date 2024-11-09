package solid;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        QuantityCalculatorFood quantityCalculatorFood = new QuantityCalculatorFood();
        // violates Liskov substitution principle
        Cloud cloud = new Cloud();
        quantityCalculatorFood.average(List.of(cloud));


        Printer printer = new Printer(new QuantityCalculatorDrink());
        Printer printer2 = new Printer(quantityCalculatorFood);
        Printer printer3 = new Printer(new CalorieCalculator());
    }
}
