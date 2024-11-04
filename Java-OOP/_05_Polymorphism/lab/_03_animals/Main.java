package _03_animals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Два типа, с които работим:
        // 1. Референтен/Форма (това е необходимо на програмиста и на компилатора)
        // 2. Реален тип на обекта (това е необходимо на JVM)
        Cat cat = new Cat("Tom", "Jerry");
        Dog dog = new Dog("Spike", "Tom");

        makeAnimalPresentThemself(cat);
        makeAnimalPresentThemself(dog);
    }

    public static void makeAnimalPresentThemself(Animal animal) {
        System.out.println(animal.explainSelf());
    }
}
