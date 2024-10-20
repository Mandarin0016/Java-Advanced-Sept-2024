import java.util.*;

public class MainLab3 {

    public static void main(String[] args) {

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(5);
        hashSet.add(7);
        hashSet.add(22);
        hashSet.add(13);
        hashSet.add(67);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(1);
        treeSet.add(77);
        treeSet.add(60);
        treeSet.add(-20);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(10);
        linkedHashSet.add(15);
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);

        Map<Integer, String> users = new HashMap<>();
        users.put(5, "Ivan");
        users.put(5, "Vik");

        String name = "Ivan"; // 2291258
        System.out.println(name.hashCode());
    }
}
