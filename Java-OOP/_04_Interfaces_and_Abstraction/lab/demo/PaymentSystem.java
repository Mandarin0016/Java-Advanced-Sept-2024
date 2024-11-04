package demo;

// Правило: когато един клас иска да имплементира интерфейс,
// той е задължен да даде имплементация на всички дефинирани методи в интерфейса
// Definition: Какво може да прави един метод!
// Implementation: Как се извършва дадено действие!
public class PaymentSystem implements Payable, Payable2, Discountable {

    public static final String SYSTEM_URL = "https://payment-system.com";

    @Override
    public boolean payWithCard(int productCost, int cardBalance) {

        if (productCost > cardBalance) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void payWithCash() {

    }

    @Override
    public String generateDiscountCode() {
        return "code";
    }
}
