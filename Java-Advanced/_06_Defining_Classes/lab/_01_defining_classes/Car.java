package _01_defining_classes;

// Шаблон
public class Car {

    // полета - характеристики
    private String brand;
    private String model;
    private int horsePower;

    // методи - поведение
    // с този метод давам достъп до стойността на полето brand
    // Getters - методи, които ми осигуряват контроплиран достъп до полетата на моят клас и връщат стойността на конкретно поле
    // getter за полето brand
    public String getBrand() {
        // Проверка за достъп!
        return this.brand;
    }

    // getter за полето model
    public String getModel(){
        return this.model;
    }

    public int getHorsePower(){
        return this.horsePower;
    }

    // Контролиран достъп до полетата на класа!
    // Setters - методи, които ми осигуряват контроплиран достъп до полетата на моят клас, с тях задавам стойност на конкретно поле
    // setter за полето brand
    public void setBrand(String brand) {
        // this - достъп до обекта, който извиква този метод
        this.brand = brand;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public String carInfo(){
        return String.format("The car is: %s %s - %d HP.", this.brand, this.model, this.horsePower);
    }
}
