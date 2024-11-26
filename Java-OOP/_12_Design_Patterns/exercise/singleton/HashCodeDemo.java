package singleton;

public class HashCodeDemo {

    public static void main(String[] args) {

        HashCode instance1 = HashCode.getInstance("Kaloyan");
        HashCode instance2 = HashCode.getInstance("Peter");

        System.out.println(instance1.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());

        System.out.println("Kaloyan".hashCode());
    }
}
