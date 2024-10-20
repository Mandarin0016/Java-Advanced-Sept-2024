package _02_library;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public Iterator<Book> iterator() {
        return new BookIterator();
    }

    private class BookIterator implements Iterator<Book> {

        private int index = 0;

        // Ако не съм стигнал броят на книгите - тогава имам следваща книга
        public boolean hasNext() {
            return index < books.length;
        }

        public Book next() {
            Book book = books[index];
            index++;
            return book;
        }
    }
}
