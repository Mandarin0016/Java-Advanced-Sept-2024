package SingletonDemo;

public class Main {

    public static void main(String[] args) {

        Database database = Database.getInstance();
        database.add("Gosho");
        database.add("Ivan");
        database.add("Joro");

        Database mydatabase = Database.getInstance();
        mydatabase.add("Vik");
        System.out.println();
    }
}
