package SingletonDemo;

import java.util.ArrayList;
import java.util.List;

// Singleton design pattern
public class Database {

    // 2. Field that will store one instance of the class
    private static Database instance;

    private List<Object> objects;

    // 1. private constructor
    private Database() {
        this.objects = new ArrayList<>();
    }

    // 3. static method to return that one instance
    public static Database getInstance() {

        // If already an instance exist from this class, return it
        if (instance != null) {
            System.out.println("An instance already exist, here you go!");
            return instance;
        }
        // Create only one instance/object out of this class
        System.out.println("A new instance is created for you, here you go!");
        instance = new Database();
        return instance;
    }

    public void add(Object object) {
        this.objects.add(object);
    }
}
