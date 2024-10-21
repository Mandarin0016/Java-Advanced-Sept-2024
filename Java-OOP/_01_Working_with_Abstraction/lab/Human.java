public class Human {

    private City city;
    private Month monthOfBirth;

    public Human(City city) {
        this.city = city;
    }

    // Вложен клас
    private static class City {

    }
}
