public class odd_even_indices {
    class Node {
        int data;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node oddEvenList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node odd = head;
        Node even = head.next;
        Node evenhead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }

    public static void printLinkedList(Node head) {
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        odd_even_indices obj = new odd_even_indices();
        Node head = obj.new Node(10);
        head.next = obj.new Node(20);
        head.next.next = obj.new Node(5);
        head.next.next.next = obj.new Node(8);
        head.next.next.next.next = obj.new Node(9);
        head.next.next.next.next.next = obj.new Node(4);
        head.next.next.next.next.next.next = obj.new Node(1);
        System.out.println("Original Linked list:");
        printLinkedList(head);
        head = obj.oddEvenList(head);
        System.out.println("Linked list after segregating odd and even indices:");
        printLinkedList(head);

    }
}