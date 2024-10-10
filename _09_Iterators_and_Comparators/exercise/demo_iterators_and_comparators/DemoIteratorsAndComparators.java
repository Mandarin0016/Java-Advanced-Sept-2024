package demo_iterators_and_comparators;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DemoIteratorsAndComparators {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] varArgs = {"2023", "WBAN244348304"};

        demo_iterators_and_comparators.Car opel = new demo_iterators_and_comparators.Car("Opel", 105);
        demo_iterators_and_comparators.Car tesla = new demo_iterators_and_comparators.Car("Tesla", 500, "2023");
        demo_iterators_and_comparators.Car tesla3 = new demo_iterators_and_comparators.Car("Tesla", 700, varArgs);

        int res = opel.compareTo(tesla);

        List<demo_iterators_and_comparators.Car> cars = List.of(opel, tesla, tesla3);

        //        cars.stream()
////            .sorted((car1, car2) -> car1.compareTo(car2))
//            .sorted(demo.CarComparator.carComparator.reversed())
//            .forEach(System.out::println);

//        Comparator<demo.Car> carComparator = demo.CarComparator.carComparator;
//        System.out.println(carComparator.compare(opel, tesla));

        someMethod(CarComparator.carComparator, opel, tesla);



        // demo.Garage Iterator example


        Garage garage = new Garage(new demo_iterators_and_comparators.Car[] {opel, tesla, tesla3});

//        for (demo.Car car : garage) {
//
//        }
        Iterator<demo_iterators_and_comparators.Car> iterator = garage.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    static  void someMethod(Comparator<demo_iterators_and_comparators.Car> carComparator, demo_iterators_and_comparators.Car car1, Car car2){
        System.out.println(carComparator.compare(car1, car2));
    }

}
