package demo.dynamic_polymorphism;

public class RevolutPayment implements Payable {

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + " is payed by RevolutPayment");
    }
}
