package demo;

public abstract class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public String getName() {
        return name;
    }

    public abstract void sayMyRole();

    public abstract void sayMyName();
}
