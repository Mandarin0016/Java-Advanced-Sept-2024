package prototype;

public class PrototypeDemo {

    public static void main(String[] args) {
        SportCar ferrari = new SportCar("Ferrari", 700);
        Car copy = ferrari.copy();

        System.out.println();
    }
}
