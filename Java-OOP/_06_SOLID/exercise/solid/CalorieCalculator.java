package solid;

import java.util.List;

public class CalorieCalculator implements Calculator<Product> {

    public CalorieCalculator() {
    }

    public double sum(List<Product> products) {
        return products.stream().mapToDouble(Product::amountOfCalories).sum();

    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
