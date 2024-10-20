import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BogoSort {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(new Integer[]{5, 2, 1, 6, 8});

        List<Integer> sortedList = Arrays.asList(new Integer[]{5, 2, 1, 6, 8});
        Collections.sort(sortedList);

        int count = 0;

        while (true) {
            Collections.shuffle(intList);
            count++;
            if (Arrays.equals(intList.toArray(), sortedList.toArray())) {
                System.out.println("Sorted, on time: " + count);
                return;
            }
        }

    }

}
