public class CreditCardPayment extends Payment implements Payable{


    public CreditCardPayment(String username) {
        super(username);
    }

    @Override
    public void report() {

    }

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + "is payed by Credit Card");
    }

    @Override
    public void addMoneyToAccount(int money) {
        System.out.println("Successfully added "+ money + " to Credit Card!");
    }
}
