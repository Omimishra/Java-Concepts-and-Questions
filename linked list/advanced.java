import java.util.*;

public class advanced {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        //insertion
        list.addFirst("a");
        list.addFirst("is");
        System.out.println(list);

        list.addFirst("This");
        list.addLast("list");
        System.out.println(list);

        System.out.println(list.size());//length of the list

        //printing the list
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " -> ");
        }
        System.out.println("null");

        //deletion
        list.removeFirst();
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

    }
}
