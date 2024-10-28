package demo;

// ПРАВИЛО: Всеки наследник трябва да удовлетворява конструктора на своят бащин клас
public class Elephant extends Animal {

    private int trunkLength;

    public Elephant(String name, int age, int trunkLength) {
        // конструктор на бащиният клас, той очаква 2 стойности: String name, int age
        // На първият ред от конструктора
        super(name, age);
        setTrunkLength(trunkLength);
    }

    public void setTrunkLength(int trunkLength) {
        //VALIDATION!
        this.trunkLength = trunkLength;
    }

    @Override
    public void setAge(int age) {
        // Validation
        this.age = age;
    }
}
