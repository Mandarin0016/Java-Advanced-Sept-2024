package demo_iterators_and_comparators;

import java.util.Comparator;

public class CarComparator implements Comparator<demo_iterators_and_comparators.Car>{

    private CarComparator() {
    }

    static Comparator<demo_iterators_and_comparators.Car> carComparator = (car1, car2) -> {
        if (car1.getHorsePower() == car2.getHorsePower()) {
            return 0;
        } else if (car1.getHorsePower() > car2.getHorsePower()) {
            return 1;
        }

        return -1;
    };

    @Override
    public int compare(demo_iterators_and_comparators.Car car1, Car car2) {
        if (car1.getHorsePower() == car2.getHorsePower()) {
            return 0;
        } else if (car1.getHorsePower() > car2.getHorsePower()) {
            return 1;
        }

        return -1;
    }
}
