package list_utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(20, 10, 15, 20, 40);

        System.out.println(ListUtils.getMax(numbers));

    }
}
