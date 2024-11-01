public class PaypalPayment extends Payment{

    public PaypalPayment(String username) {
        super(username);
    }

    @Override
    public void report() {

    }

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + "is payed by PayPal");

    }
}
