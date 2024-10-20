import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

        /*
        Sets keep unique elements
        HashSet<E> -> Does not guarantee the constant order of elements over time
        TreeSet<E> -> The elements are ordered incrementally
        LinkedHashSet<E> -> The order of appearance is preserved

        Maps hold a set of <key, value> pairs,
        Keys are unique
        HashMap<K, V> -> Does not guarantee the constant order of elements over time
        TreeMap<K, V> -> The elements are ordered incrementally by the key
        LinkedHashMap<K, V> -> The order of appearance is preserved

        Advanced Topics:
           - Collisions in HashMap and HashSet
           - Equals and HashCode contract
        */


public class HashMapDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //        Map<String, String> map = new HashMap<>();
        //
        //        String a = "Siblings";
        //        String b = "Teheran";
        //
        //        System.out.println(a.hashCode());
        //        System.out.println(b.hashCode());
        //
        //        map.put(a, "бафйдвоисфцйхдвеиоскйнф");
        //        map.put(b, "фффффффффффффффф");

        Map<City, Integer> cityMap = new HashMap<>();

        City sofia = new City(1, "Sofia");
        City plovdiv = new City(1, "Plovdiv");
        City varna = new City(1, "Varna");

        //        System.out.println(sofia.hashCode());
        //        System.out.println(plovdiv.hashCode());
        //        System.out.println(varna.hashCode());

        cityMap.put(sofia, 2000000);
        cityMap.put(plovdiv, 1000000);
        cityMap.put(varna, 800000);

        // sofia.setId(2);
        System.out.println();

        List<String> list = new LinkedList<>();

        for (String element : list) {

        }

        int [] numbers = new int[5];
        for (int number : numbers) {

        }
    }
}

















