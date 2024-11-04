package demo;

public class Teacher extends Person {

    public Teacher(String name) {
        super(name);
    }

    @Override
    public void sayMyRole() {
        System.out.println("I am teacher.");
    }

    @Override
    public void sayMyName() {
        System.out.println("My name is Ivan.");
    }
}
