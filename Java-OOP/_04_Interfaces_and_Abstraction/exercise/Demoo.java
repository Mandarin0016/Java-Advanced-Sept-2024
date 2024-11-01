import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demoo {

    /*
     Abstraction is a process of hiding the implementation details and providing only pure functionality to the user.

    In Java, abstraction is achieved by using the abstract keyword for classes and with interfaces.

    Abstraction describes selecting data from a larger pool to show only relevant details of the object to the user.

    It helps to reduce programming complexity and efforts.

    An interface can have all the methods and variables like the class do,
     but the methods in the interface are abstract by default.

    collection.Interfaces in Java are used to specify a behaviour that classes must implement.

    We use interfaces when we want to achieve security.

    As we know, Java does not support "multiple inheritance".
    However, we can achieve this easy with interfaces, because the class can implement multiple interfaces.

    In a typical design based on abstractions, where an interface has one or multiple implementations,
    if one or more methods are added to the interface, all the implementations will be forced to implement them too.
    Otherwise, the design will just break down.
    Default interface methods are an efficient way to deal with this issue.
    They allow us to add new methods to an interface that are automatically available in the implementations.
    Therefore, we don't need to modify the implementing classes.
    Since static interface methods don't belong to a particular object, they're not part of the API of the classes implementing the interface;
    therefore, they have to be called by using the interface name preceding the method name.
    Static methods in interfaces make it possible to group related utility methods,
    without having to create artificial utility classes that are simply placeholders for static methods.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String paymentChoice = scanner.nextLine();
        int price = Integer.parseInt(scanner.nextLine());

        Payable creditCardPayment = new CreditCardPayment("kaloyan");
        Payable revolut = new Revolut("kaloyan");
        Payable paypalPayment = new PaypalPayment("kaloyan");
        Payable bitcoin = new Bitcoin("kaloyan");

        creditCardPayment.addMoneyToAccount(150);

        Map<String, Payable> payableMap = Map.of("CreditCard", creditCardPayment,
                                                 "Revolut", revolut,
                                                 "PayPal", paypalPayment,
                                                 "Bitcoin", bitcoin);

        Payable payable = payableMap.get(paymentChoice);

        payable.pay(price);

        Payment payment = new CreditCardPayment("kaloyan");
        payment.report();

        System.out.println(Payable.calculateVat(100));
    }
}






















