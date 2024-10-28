package demo;

public class Main03 {

    public static void main(String[] args) {

        Lion lion = new Lion("Pesho", 12, "Red");
        Giraffe giraffe = new Giraffe("Ivan", 5, 300);
        Elephant elephant = new Elephant("Gosho", 15, 100);
//        Book book = new Book();

        ZooSystem zooSystem = new ZooSystem();

        zooSystem.addAnimal(lion);
        zooSystem.addAnimal(giraffe);
        zooSystem.addAnimal(elephant);
//        zooSystem.addAnimal(book);

        lion.eat();
        giraffe.eat();
        elephant.eat();

    }
}
