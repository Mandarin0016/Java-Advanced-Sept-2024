package solid.products;

import solid.Drink;

public class Coke implements Drink {

    private static final double CALORIES_PER_100_GRAMS = 44.0;
    private static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    @Override
    public double amountOfCalories() {
        double grams = milliliters * DENSITY;
        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }

    @Override
    public double amountOfDrinks() {
        return this.milliliters / 1000;
    }
}
