package Singleton;

import java.util.HashMap;
import java.util.Map;

public class SingletonDataContainer implements SingletonContainer {
    private static SingletonDataContainer instance;
    private Map<String,Integer> capitals;


    private SingletonDataContainer() {
        this.capitals = new HashMap<>();
        System.out.println("Initializing singleton object");
    }


    public int getPopulation(Map<String, Integer> capitals, String name) {
        return capitals.get(name);
    }

    public static SingletonDataContainer getInstance() {
        if (instance != null){
            return instance;
        }
        instance = new SingletonDataContainer();
        return instance;
    }
}

