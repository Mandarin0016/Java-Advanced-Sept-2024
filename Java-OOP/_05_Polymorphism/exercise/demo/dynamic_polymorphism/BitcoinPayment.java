package demo.dynamic_polymorphism;

public class BitcoinPayment implements Payable {

    @Override
    public void pay(int price) {
        System.out.println("Sum " + price + " is payed by Bitcoin");
    }
}
