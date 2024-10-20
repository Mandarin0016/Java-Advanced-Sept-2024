import java.util.Arrays;

public class DemoAlg {

    public static void main(String[] args) {

        int[] array = {5, 2, 3, 4};

        Arrays.sort(array);

        for (int number : array) {
            System.out.print(number + " ");
        }

    }
}
