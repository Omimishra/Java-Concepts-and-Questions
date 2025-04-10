public class palindrome {
    class Node {
        int data;
        Node next;
    
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    // check whether a linked list is palindrome or not by not using extra space
    public static Node reverselist(Node head) {
        if (head == null || head.next == null){
            return head;
            }
            Node newhead = reverselist(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }

    public static Node findmiddle(Node head) {
        Node hare = head;
        Node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next; // jumps by 2 steps
            turtle = turtle.next; // jumps by 1 step

        }
        return turtle; // middle of linked list
    }

    public static boolean ispalindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node middle = findmiddle(head); // 1st half ka end
        Node secondHalfStart = reverselist(middle.next);
        Node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
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
        palindrome obj = new palindrome();
        // Create a linked list: 1 -> 5 -> 2 -> 5 -> 1
       Node head = obj.new Node(1);
        head.next = obj.new Node(5);
        head.next.next = obj.new Node(2);
        head.next.next.next = obj.new Node(5);
        head.next.next.next.next = obj.new Node(1);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Check if the linked list is a palindrome
        if (ispalindrome(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
    }

