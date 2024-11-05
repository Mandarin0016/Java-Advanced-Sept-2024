package demo.dynamic_polymorphism;

public class CreditCardPayment implements Payable {

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + " is payed by Credit Card");
    }

    @Override
    public void addMoneyToAccount(int money) {
        System.out.println("Successfully added "+ money + " to Credit Card!");
    }
}
