package demo;

import java.util.Map;
import java.util.Scanner;

import demo.dynamic_polymorphism.BitcoinPayment;
import demo.dynamic_polymorphism.CreditCardPayment;
import demo.dynamic_polymorphism.Payable;
import demo.dynamic_polymorphism.PaypalPayment;
import demo.dynamic_polymorphism.RevolutPayment;

public class Demo {

    /*

        Polymorphism is the ability of an object to take on different forms.

        In Java, polymorphism refers to the ability of a class to provide different implementations of a method,
        depending on the type of object that is passed to the method.

        There are two types of polymorphism dynamic and static A.K.A runtime and compile time.

        The static polymorphism can be achieved by method overloading.
        Overloading allows different methods to have the same name,
        but different signatures where the signature can differ by the number of input parameters
        or type of input parameters or both.
        Overloading is related to compile-time (or static) polymorphism.

        Dynamic polymorphism: Overriding is a feature that allows a subclass
        or child class to provide a specific implementation of a method
        that is already provided by one of its super-classes or parent classes.

        When a method in a subclass has the same name, same parameters or signature,
        and same return type (or sub-type) as a method in its super-class,
        then the method in the subclass is said to override the method in the super-class.
     */
    public static void main(String[] args) {
//        // Static Polymorphism
//        Printer printer = new Printer();
//
//        printer.print("Kaloyan");
////        printer.print("Kaloyan", "Kostadinov");
////        printer.print(15);
////        printer.print(1.5);

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Payable payable = getPayable(line);
        pay(payable, 150);
    }

    private static void pay(Payable payable, int amount) {
        payable.pay(amount);
    }

    private static Payable getPayable(String payment) {

        Map<String, Payable> payableMap = Map.of("CreditCard", new CreditCardPayment(),
                                                 "RevolutPayment", new RevolutPayment(),
                                                 "PayPal", new PaypalPayment(),
                                                 "Bitcoin", new BitcoinPayment());

        return payableMap.get(payment);
    }
}
