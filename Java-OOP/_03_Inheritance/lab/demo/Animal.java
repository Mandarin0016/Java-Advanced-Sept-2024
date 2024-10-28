package demo;

public class Animal {

    private String name;
    protected int age;

    public Animal(String name, int age) {
        setName(name);
        setAge(age);
    }

    public void eat() {
        System.out.println("This animal is eating...");
    }

    public void setName(String name) {
        // VALIDATION!
        this.name = name;
    }

    public void setAge(int age) {
        // VALIDATION!
        this.age = age;
    }
}
