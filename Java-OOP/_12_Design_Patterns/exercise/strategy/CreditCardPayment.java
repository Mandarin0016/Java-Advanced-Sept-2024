package strategy;

public class CreditCardPayment implements Payment{

    @Override
    public void pay(int amount) {
        System.out.println("Payed with CreditCard!");
    }
}
