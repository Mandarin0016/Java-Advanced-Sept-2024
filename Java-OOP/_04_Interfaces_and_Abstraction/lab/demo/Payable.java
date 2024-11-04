package demo;

// Интерфейс = съвкупност от методи без имплементация, които ще може да извършват нашите класове в последствие.
// Интерфейс = договор
public interface Payable extends Cashable {

    // 1. Статични полета
    public static final int MAX_BANK_ACCOUNTS = 5;

    // 2. Абстрактни методи - method definitions
    public abstract boolean payWithCard(int productCost, int cardBalance);
}
