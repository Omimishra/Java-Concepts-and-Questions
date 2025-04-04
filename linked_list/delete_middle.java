public class delete_middle {
class Node {
    int data; 
    Node next;     
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
    static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        // Initialize slow and fast pointers
        Node slow = head;
        Node fast = head;
        fast = head.next.next;

        // Move 'fast' pointer twice as fast as 'slow'
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }

    static void printLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list:
        delete_middle list = new delete_middle();
        Node head = list.new Node(1);
        head.next = list.new Node(2);
        head.next.next = list.new Node(3);
        head.next.next.next = list.new Node(4);
        head.next.next.next.next = list.new Node(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        head = deleteMiddle(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}



