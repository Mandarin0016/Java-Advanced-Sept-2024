public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList) {
        // 4 9 2 8 7 => 2 4 7 8 9

        for (int i = 0; i < customList.size(); i++) {
            T currentElement = customList.get(i);
            for (int j = i + 1; j < customList.size(); j++) {
                if (currentElement.compareTo(customList.get(j)) > 0) {
                    customList.swap(i, j);
                }
            }
        }
    }
}
