package demo;

// this  - за да реферираме към елементите на този конкретен клас
// super - за да реферираме към елементите в бащиният/базовият клас
public class Lion extends Animal {

    private String maneColor; // грива

    public Lion(String name, int age, String maneColor) {
        super(name, age);
        this.maneColor = maneColor;
    }

    @Override
    public void eat() {
        System.out.println("The lion is eating meat!!!");
    }

    public void roar() {
        System.out.println("The lion is roaring and his mane color is " + this.maneColor);
    }
}
