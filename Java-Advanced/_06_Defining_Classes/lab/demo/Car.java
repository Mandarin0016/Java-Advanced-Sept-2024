package demo;

// Шаблон
public class Car {

    // полета - характеристики
    // {модификатор за достъп} {тип данни} {име}
    // {модификатор за достъп}:
    // public - навсякъде мога да достъпвам това поле
    // private - само в рамките на класа (ПО–ПРАВИЛНО!!!!)
    private String brand;
    private String model;
    private int horsePower;

    // Това default конструктор на класа -> създава празен оебкт
    public Car() {
        //brand = null
        //model = null
        //horsePower = 0
    }

    // Този конструктор създава обект от този клас, като задава стойности на полетата още при самото създаване на обекта.
    // Констреуктор - специален метод, който се грижи за това да създава обекти от моят клас
    // Като се влезе в конструктора - обекта е празен
    // Като изляза от конструктора - полетат ще имат стойности
    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    // методи - поведение
    public void drive() {
        System.out.println("Car is moving!");
    }

    // с този метод давам достъп до стойността на полето brand
    public String getBrand() {
        // Проверка за достъп!
        return this.brand;
    }

    // Контролиран достъп до полетата на класа!
    public void setBrand(String brand) {
        // this - достъп до обекта, който извиква този метод
        this.brand = brand;
    }

    // toString - връща обекта под формата на текст
    public String toString() {
        return "This is car with brand " + this.brand;
    }

    public boolean equals(Car car) {
        return this.brand.equals(car.brand);
    }

    // Статични методи - това са методи, които може да изпълняваме посредством класа и не ни е необходима инстанция на този клас!
    public static void beep(){
        System.out.println("Beep, beep!");
    }
}
