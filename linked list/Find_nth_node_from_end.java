// import java.util.*;
//Find the nth node from the end and remove it.
public class Find_nth_node_from_end {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public void addLast(int data) {
        Node newnode = new Node(data);

        if (head == null) {
            head = newnode;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newnode;

    }

    public void printlist() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL");

    }

    public Node removeNthNode(Node head, int n) {
        if (head.next == null) {
            return null;

        }
        int size = 0;
        Node currNode = head;
        while (currNode != null) {
            currNode = currNode.next;
            size++;
        }
        // removing SIZEth node from last i.e head
        if (n == size) {
            return head.next;
        }

        // find previous node 
        int indexToSearch = size - n; // position to find 
        Node prev = head; // previous node
        int i = 1;
        while (i < indexToSearch) { // iterate to find the true position of previous node
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static void main(String[] args) {
        Find_nth_node_from_end list = new Find_nth_node_from_end();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        System.out.println("Enter the Nth node from the end of the list");
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        list.head = list.removeNthNode(list.head, 3);
        list.printlist();
    }
}
