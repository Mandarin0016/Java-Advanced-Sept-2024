package demo;

public class Book {

    private String authorName;
    private double price;

    // Защо тук дефинирам, че фвърлям грешка:
    // защото тази грешка е наследник на класа Exception;
    public Book(String authorName, double price)  {
        setAuthorName(authorName);
        setPrice(price);
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setPrice(double price)  {
        // Прекратявам създаването на тази книга!
        if (price < 0) {
            // Хвърлям exception, който е наследник на класа Exception
            throw new IllegalArgumentException("Invalid number " + price + " for Book price, make sure the price is positive number!");
        }
        this.price = price;
    }
}
