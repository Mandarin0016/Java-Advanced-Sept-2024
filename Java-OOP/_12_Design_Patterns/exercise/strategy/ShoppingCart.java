package strategy;

public class ShoppingCart {

    public void pay(Payment payment, int amount) {
        payment.pay(amount);
    }
}
