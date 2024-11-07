package examples.LSP;

import javax.naming.OperationNotSupportedException;

public class Main {

    public static void main(String[] args) throws OperationNotSupportedException {

        // Бащин клас
        Worker worker = new Worker();
        Restaurant.processOrder(worker);

        // Дъщерен клас 1
        Person person = new Person();
        Restaurant.processOrder(person);

        // Дъщерен клас 2
        Robot robot = new Robot();
        Restaurant.processOrder(robot);

        // Всеки дъщерен клас трябва да може да прави това, което бащиният клас описва като действия
    }
}
