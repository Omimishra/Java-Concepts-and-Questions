package hashing;

import java.util.*;

public class creation_hashset {
    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        //unordered
        // insert
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);

        // size
        System.out.println("Size of the set is " + set.size());

        //print all elements
        System.out.println(set);

        // search
        // if (set.contains(1)) {
        //     System.out.println("Set contains 1 ");
        // }
        // if (!set.contains(6)) {
        //     System.out.println("Does not contain 6");

        // }

        // // delete
        // set.remove(1);
        // if (!set.contains(1)) {
        //     System.out.println("we deleted 1");
        // }

        //Iterator
        Iterator it = set.iterator();
        //hasNext(); next()

        while (it.hasNext()) {
            System.out.println(it.next());
            
        }

    }
}
