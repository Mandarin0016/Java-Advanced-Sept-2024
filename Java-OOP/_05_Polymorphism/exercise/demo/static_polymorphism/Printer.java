package demo.static_polymorphism;

public class Printer {

    // Method to print a string
    public void print(String message) {
        System.out.println("String: " + message);
    }

    // Method to print two strings
    public void print(String message1, String message2) {
        System.out.printf("String: %s\n" +
                          "String: %s", message1, message2);
    }

    // Method to print an integer
    public void print(int number) {
        System.out.println("Integer: " + number);
    }

    // Method to print a double
    public void print(double decimal) {
        System.out.println("Double: " + decimal);
    }
}
