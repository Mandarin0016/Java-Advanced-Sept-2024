public class Container<T> {

    private T value;

    public Container(T value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }

    public T getValue() {
        return value;
    }
}

//// Type Erasure
//public class Container {
//
//    private Object value;
//
//    public Container(Object value) {
//        this.value = value;
//    }
//
//    public void print() {
//        System.out.println((String) value);
//    }
//}
