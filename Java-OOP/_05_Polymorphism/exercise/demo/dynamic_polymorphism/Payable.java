package demo.dynamic_polymorphism;

public interface Payable {

    void pay(int price);

    default void addMoneyToAccount(int money) {
        System.out.printf("Service addMoneyToAccount is not available for %s!\n",
                          this.getClass().getSimpleName());
    }

    static double calculateVat(int amount) {

        return amount * 0.2;
    }
}
