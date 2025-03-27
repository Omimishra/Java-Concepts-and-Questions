import java.util.*;

// Take elements (numbers in the range of 1-50) of a linked list as input from the user . Delete all nodes which have values greater than 25
public class delete_nodes_above_25 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number  of nodes you want to input ");
        int size = sc.nextInt();

        System.out.println("Enter numbers between 1 to 50");
        for (int i = 0; i < size; i++) {
            list.add(sc.nextInt());
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > 25) {
                list.remove(i);
            }
        }

        System.out.println(list);
    }
}
