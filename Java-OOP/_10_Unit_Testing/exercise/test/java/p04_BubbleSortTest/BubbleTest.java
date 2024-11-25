package p04_BubbleSortTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleTest {

    @Test
    void test_Sort_Should_Sort_Ascending_Order() {
        int[] expectedValues = {-8, 0, 1, 7, 9, 9, 45, 45};
        int[] actualValues = {45, 1, -8, 0, 45, 7, 9, 9};

        Bubble.sort(actualValues);

        Assertions.assertArrayEquals(expectedValues, actualValues);
    }

}
