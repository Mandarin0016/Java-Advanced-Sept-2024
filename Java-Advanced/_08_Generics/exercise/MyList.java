import java.util.List;

public class MyList<T> {

    void someMethod(List<? extends T> numbers) {
        T t = numbers.get(0);
    }

    public <E extends T> void someStaticMethod(List<E> list) {
        E el = list.get(0);
        for (E element : list) {
            System.out.println(element);
        }
    }
}
