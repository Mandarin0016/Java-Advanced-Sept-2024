package scale;

public class Scale<T extends Comparable<T>> {

    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {

        // Всеки сравним елемент (обект, който наследява Comparable) се сравнява с метода .compareTo(el)
        int result = left.compareTo(right);
        // 0, 1 и -1
        // 0 = двата обекта са равни
        // 1(или число по-голямо от 1 -положително число) = първият обекта е по-голям от вторият
        // -1(или число по-малко от -1 -отрицателно число) = първият обекта е по-малък от вторият

        // двата обекта са равни
        if (result == 0) {
            return null;
        } else if (result >= 1){
            return left;
        } else {
            return right;
        }
    }
}
