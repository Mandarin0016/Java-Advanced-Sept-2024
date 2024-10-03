package array_creator;

import java.lang.reflect.Array;

public class ArrayCreator {

    // {access_modifier} static {<generic_parameter>} {return_type} {name}(){}

    public static <T> T[] create(int length, T item) {

//        int[] numbers = new int[2];
//        int[] numbers2 = (int[]) Array.newInstance(Integer.class, 10);

        // Array.newInstance -> създавам нов масив от конкретен клас и дадена дължина
        T[] array = (T[]) Array.newInstance(item.getClass(), length);

        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] array = (T[]) Array.newInstance(clazz, length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}
