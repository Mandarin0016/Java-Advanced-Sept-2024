package _11_CatLady;

public class Siamese extends Cat {

    private double earSize;

    public Siamese(String name, String type, double earSize) {
        super(name, type);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.earSize);
    }
}
