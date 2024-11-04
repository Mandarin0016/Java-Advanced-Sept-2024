package demo;

import car.Car;

public class Student extends Person {


    public Student(String name) {
        super(name);
    }

    @Override
    public void sayMyRole() {
        System.out.println("I am student.");
    }

    @Override
    public void sayMyName() {
        System.out.println("My name is Vik.");
    }
}
