package list_utils;

import java.util.Collections;
import java.util.List;

public class ListUtils {

    // най-малък елемент от списък с елементи
    // List<Integer> -> Integer
    // List<String> -> String
    // List<Long> -> Long
    // Искам списък с елементи, които да бъдат сравними със себе си
    public static <E extends Comparable<E>> E getMin(List<E> list) {

        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return Collections.min(list);
    }

    // най-голям елемент от списък с елементи
    public static <E extends Comparable<E>> E getMax(List<E> list) {

        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }

        return Collections.max(list);
    }

    // T extends Object - трябва да е обект
    // Comparable<T> - трябва да бъде сравним
    //<T extends Object & Comparable<T>>
}
