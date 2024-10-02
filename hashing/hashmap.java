package hashing;

import java.util.*;

public class hashmap {
    public static void main(String[] args) {

        // unordered
        // country(key),population(value)
        HashMap<String, Integer> map = new HashMap<>();

        // Insertion
        map.put("India", 120);
        map.put("US", 30);
        map.put("China", 150);

        System.out.println(map);

        // map.put("China", 180);
        // System.out.println(map);

        // // search lookup
        // if (map.containsKey("China")) {
        // System.out.println("Key is present in the map");

        // } else {
        // System.out.println("Key is not present in the map");
        // }

        System.out.println(map.get("China")); // key exists
        System.out.println(map.get("Indonesia")); // key does not exists

        // int arr[] = { 12, 15, 18 };
        // for (int i = 0; i < 3; i++) {
        // System.out.print(arr[i] + " ");
        // }
        // System.out.println();

        // for (int val : arr) {
        // System.out.print(val + " ");
        // }
        // System.out.println();

        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        Set<String> keys = map.keySet(); // returns keys of the hashmap

        for (String key : keys) {
            System.out.println(key + " " + map.get(key));
        } // value corresponding to key

        map.remove("China");
        System.out.println(map);
    }
}
