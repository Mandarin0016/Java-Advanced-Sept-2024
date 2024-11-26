package strategy;

public class PayPalPayment implements Payment {

    @Override
    public void pay(int amount) {
        System.out.println("Payed with PayPalPayment!");
    }
}
