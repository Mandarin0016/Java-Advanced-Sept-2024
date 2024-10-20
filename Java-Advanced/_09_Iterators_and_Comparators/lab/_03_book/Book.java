package _03_book;

import java.util.ArrayList;
import java.util.List;

public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    //-setTitle(String)
    //-setYear(String)
    //-setAuthors(String…)
    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    // 0 или повече автора
    private void setAuthors(String... authors) {
        this.authors = new ArrayList<>();
        for (String author : authors) {
            this.authors.add(author);
        }
    }

    //+getTitle(): String
    //+getYear(): int
    //+getAuthors(): List<String>
    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    // book1.compareTo(book2)
    public int compareTo(Book otherBook) {

        //The book has to be compared by title. When the title is equal, compare them by year.
        int result = this.title.compareTo(otherBook.title);
        // Книгите имат същите заглавия
        if (result == 0) {
            result = Integer.compare(this.year, otherBook.year);
        }
        return result;
    }
}
