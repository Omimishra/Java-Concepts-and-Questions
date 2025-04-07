package hard;
class Node {
    int data;
    Node next;
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class reverse_in_k_groups {
    static Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    static Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        // Return the Kth node
        return temp;
    }

    // Function to reverse nodes in groups of K
    static Node kReverse(Node head, int k) {
        Node temp = head;
        Node prevLast = null;
        while (temp != null) {
            Node kThNode = getKthNode(temp, k);
            // If the Kth node is NULL(not a complete group)
            if (kThNode == null) {
                // If there was a previous group,link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            } // Store the next node after the Kth node
            Node nextNode = kThNode.next;
            kThNode.next = null;
            reverseLinkedList(temp);
            if (temp == head) {
                head = kThNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }
            prevLast = temp;
             temp = nextNode;
        }
        return head;
    }
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with
        // values 5, 4, 3, 7, 9 and 2
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
