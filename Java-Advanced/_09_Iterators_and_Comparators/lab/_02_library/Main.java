package _02_library;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Harry Potter", 2000);
        Book book2 = new Book("Hobbit", 2000, "Vik", "Desi", "Kris");

        Library library = new Library(book1, book2);

        for (Book book : library) {
            System.out.println(book);
        }
    }
}
