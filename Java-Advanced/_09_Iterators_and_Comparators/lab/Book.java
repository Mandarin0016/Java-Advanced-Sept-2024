import java.util.Iterator;
import java.util.List;

// Iterable - дава възможност на моят клас да бъде обходим
// Book implements Iterable<String> = моят клас Книга ще бъде обходим (ще може да се обхожда)
// implements Iterable<тип на елементите, които ще се обхождат от моят клас>
public class Book implements Iterable<String> {

    private List<String> pages;

    public Book(String... pages) {
        this.pages = List.of(pages);
    }

    // Ето това е итератора за моята обходима книга!
    // Как се обхождат тези страници?
    // Iterator = начина по който ще се обхождат елементите на този клас
    // Iterator<тип данни, които се обхождат>
    public Iterator<String> iterator() {
        return new PageIterator();
    }

    // Iterator = вътрешен клас, който ще опише начина по който се обхождат страниците на моята книга
    // Какво може да прави един клас, който нарича себе си Iterator(обходител)?
    // 1. Трябва да знае има ли следваща страница?
    // 2. Трябва да може да ми връща следващата страница от моята книга, ако има такава!
    private class PageIterator implements Iterator<String> {

        private int index = 0;

        public boolean hasNext() {
            return index < pages.size();
        }

        public String next() {
            String page = pages.get(index);
            index++;
            return page;
        }
    }
}
