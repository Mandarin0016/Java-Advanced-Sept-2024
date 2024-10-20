public class DemoRecursion {

    public static void main(String[] args) {
        doSomething(5);
    }

    private static void doSomething(int count) {
        System.out.println("Invoke doSomething!");

        count--;

        if (count == 0){
            return;
        }
        doSomething(count);
    }
}
