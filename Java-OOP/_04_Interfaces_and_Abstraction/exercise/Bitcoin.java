
public class Bitcoin extends Payment implements Payable {

    public Bitcoin(String username) {
        super(username);
    }

    @Override
    public void report() {

    }

    @Override
    public void pay(int price) {
        System.out.println("Bitcoin ");
    }
}
