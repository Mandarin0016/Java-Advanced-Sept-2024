package _11_CatLady;

public class Cat {

    private String name;
    private String type;

    public Cat(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.type, this.name);
    }
}
