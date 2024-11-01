public class Revolut extends Payment implements Payable {

    public Revolut(String username) {
        super(username);
    }

    @Override
    public void report() {

    }

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + "is payed by Revolut");
    }
}
