package demo_iterators_and_comparators;

import java.util.Iterator;

public class Garage implements Iterable<demo_iterators_and_comparators.Car>{

    private demo_iterators_and_comparators.Car[] cars;

    public Garage(demo_iterators_and_comparators.Car[] cars) {
        this.cars = cars;
    }

    @Override
    public Iterator<demo_iterators_and_comparators.Car> iterator() {
        return new CustomCarIterator();
    }

    private class CustomCarIterator implements Iterator<demo_iterators_and_comparators.Car>{

        int index = cars.length - 1;

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Car next() {
            return cars[index--];
        }
    }
}
