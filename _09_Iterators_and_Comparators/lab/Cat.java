// Искам котките да могат да се сравняват
// Казвам изрично, че тези обекти от този клас са сравними
public class Cat implements Comparable<Cat> {

    private String name;
    private int age;
    private double weight;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // Описвам начина по който се сравняват две котки по даден критерии (например по години, по тегло, по име, по цвят на козината...)
    // cat1.compareTo(cat2)
    public int compareTo(Cat otherCat) {

        // Резултат от сравнението на два обекта:
        // Отрицателно число: моята котка е "по-малка" по даден критерии от другата котка
        //              Нула: и двете котки са "равни" по даден критерии
        // Положително число: моята котка е "по-голяма" по даден критерии от другата котка

        return Double.compare(this.weight, otherCat.weight);
    }
}
