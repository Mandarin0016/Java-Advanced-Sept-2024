public class Demo {

    public static void main(String[] args) {

        // Преди компилация
        Container<String> textContainer = new Container<>("Ivan");

        textContainer.print();
        String value = textContainer.getValue();


        // След компилация - Type Erasure
        Container textContainer2 = new Container((String) "Ivan");

        textContainer.print();
        String value2 = (String) textContainer.getValue();
    }
}
