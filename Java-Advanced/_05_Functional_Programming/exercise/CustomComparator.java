import java.util.Comparator;

public class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        // first even, second odd -> not swap
        if (first % 2 == 0 && second % 2 != 0) {
            return -101;
        }
        // first odd, second even -> swap
        else if (first % 2 != 0 && second % 2 == 0) {
            return 101;
        } else { // sort ascending order
            return first.compareTo(second);
        }
    }


}
