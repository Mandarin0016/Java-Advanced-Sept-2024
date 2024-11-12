package reflection_demo;

@Author(name = "Vik", age = 23, salary = 100)
public class Person implements Talker, Singer, Walker {

    @Author(name = "Vik", age = 23, salary = 100)
    private String id;
    private final String name;
    private int age;

    public Person() {
        this.name = "some_dummy_name";
        this.age = 222;
    }

    private Person(String name) {
        this.name = name;
        this.age = 222;
    }

    @Author()
    private Person(int age) {
        this.name = "some_dummy_name";
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void tellSum(int a, int b) {
        System.out.println(a + b);
    }

    @Author()
    private void tellSum(int a, int b, int c) {
        System.out.println(this.name);
        System.out.println(a + b + c);
    }

    private static void hello(String name) {
        System.out.println("Hello " + name);
    }
}
