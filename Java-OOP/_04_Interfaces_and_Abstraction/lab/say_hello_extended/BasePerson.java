package say_hello_extended;

public abstract class BasePerson implements Person {

    private String name;

    public BasePerson(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
