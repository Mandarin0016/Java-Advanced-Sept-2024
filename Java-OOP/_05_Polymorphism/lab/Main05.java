import java.util.*;

public class Main05 {

    public static void main(String[] args) {

        //{форма} променлива = {обект}
        Object computer = new Computer();

        // ПРАВИЛО: Всеки обект може да заема форма на тип на бащин клас
        // Формата е самият клас
        Laptop laptop1 = new Laptop();

        // Формата е тип от бащин клас
        Computer laptop2 = new Laptop();
        Object laptop3 = new Laptop();
        Device device = new Laptop();

        Computer laptop = new Laptop();
        Computer smartPhone = new SmartPhone();
        Computer tablet = new Tablet();

        makeComputerConnectToInternet(laptop);
        makeComputerConnectToInternet(smartPhone);
        makeComputerConnectToInternet(tablet);

        // Method polymorphism:
        // 1. Method Overriding = Java decides which method implementation to execute at runtime (Runtime polymorphism)

    }

    public static void makeComputerConnectToInternet(Computer computer) {

        // Casting
        // Преди да извършим кастване, трябва да проверим дали обекта е инстанция на класа, към който ще кастваме
        if (computer instanceof Laptop) {
            ((Laptop) computer).open();
        }

        Class<? extends Computer> aClass = computer.getClass();
        if (aClass == Laptop.class) {
            ((Laptop) computer).open();
        }
        computer.establishInternetConnection();
    }
}
