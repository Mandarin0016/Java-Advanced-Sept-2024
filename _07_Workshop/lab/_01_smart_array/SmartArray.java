package _01_smart_array;

import java.util.function.Consumer;

public class SmartArray {

    // В този масив ще съхраняваме всички цели числа
    private int[] data;
    // Колко на брой числа в момента се съхраняват
    private int size;
    // Колко общо на брой числа могат да се съхранят
    private int capacity;

    public SmartArray() {
        this.size = 0;
        this.capacity = 4;
        this.data = new int[capacity];
    }

    //void add(int element) - Adds the given element to the end of the list
    public void add(int element) {
        // Ако няма повече място, тогава увеличавам капацитета
        if (this.size == this.capacity) {
            grow();
        }
        this.data[size] = element;
        this.size++;
    }

    private void grow() {
        this.capacity *= 2;
        int[] temporary = new int[capacity];
        for (int index = 0; index < this.data.length; index++) {
            temporary[index] = this.data[index];
        }
        this.data = temporary;
    }

    //int get(int index) - Returns the element at the specified position in this list
    public int get(int index) {
        // валидирам индекса [0 - индкеса на последният елемент]
        checkIndex(index);
        return this.data[index];
    }

    private void checkIndex(int index) {
        // Ако индекса е < 0 или >= размера - невалиден индекс
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
    }

    //int remove(int index) - Removes the element at the given index
    public int remove(int index) {

        // Валидирам индекса
        checkIndex(index);

        int removedElement = this.data[index];

        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;
        this.size--;

        // Проверяваме след премахване дали е останало прекалено много свободно място
        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return removedElement;
    }

    // Намлям втрешният масив 2 пъти
    private void shrink() {
        this.capacity /= 2;
        int[] temporary = new int[capacity];
        for (int index = 0; index <= this.size - 1; index++) {
            temporary[index] = this.data[index];
        }
        this.data = temporary;
    }

    //void add(int index, int element) - Adds element at the specific index, the element at this
    // index gets shifted to the right alongside any following elements, increasing the size
    public void add(int index, int element) {
        // A:
        int lastElement = this.data[this.size - 1];
        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        add(lastElement);
        this.data[index] = element;

//        // B:
//        // Ако няма повече място, тогава увеличавам капацитета
//        if (this.size == this.capacity) {
//            grow();
//        }
//        for (int i = this.size - 1; i >= index; i--) {
//            this.data[i + 1] = this.data[i];
//        }
//        this.data[index] = element;
    }


    //bool contains(int element) - Checks if the list contains the given element returns (True or False)
    public boolean contains(int element) {
        for (int index = 0; index < this.size; index++) {
            if (this.data[index] == element) {
                return true;
            }
        }
        return false;
    }

    //void forEach(Consumer<Integer> consumer) - Goes through each one of the elements in the list
    public void forEach(Consumer<Integer> consumer) {
        for (int index = 0; index < this.size; index++) {
            consumer.accept(this.data[index]);
        }
    }
}
