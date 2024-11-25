package Facade;

public class PaymentProcessor {

    public static void processPayment() {
        CardPayment cardPayment = new CardPayment();
        cardPayment.getCard();

        CardValidator cardValidator = new CardValidator();
        cardValidator.validateCard();

        cardPayment.payWithCard();

        BalanceReducer reducer = new BalanceReducer();
        reducer.reduceBalance();

        NotificationSender notificationSender = new NotificationSender();
        notificationSender.sendNotification();
    }
}
