package say_hello;

public interface Person {

    //+getName(): String
    String getName();

    //+sayHello(): String
    String sayHello();

    default void sayBye() {
        System.out.println("Bye bye!!!");
    }

    static void sayGoodMorning() {
        System.out.println("Good morning!");
    }
}
