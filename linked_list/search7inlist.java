import java.util.*;

// make a linked list and add the following elements to it . search for the number 7 and display its index.

public class search7inlist {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(3);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 7) {
                System.out.println("Number 7 is found at index " + i);
                break;
            }
        }

    }
}
