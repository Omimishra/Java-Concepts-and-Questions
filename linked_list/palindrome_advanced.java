import java.util.LinkedList;

public class palindrome_advanced {
    // check whether a linked list is palindrome or not by creating a new linked list
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<Integer> newlist = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            newlist.add(list.get(i));
        }
        System.out.println(newlist);
        if (list.containsAll(newlist)) {
            System.out.println("true");
        } else
            System.out.println("false");
    }
}
