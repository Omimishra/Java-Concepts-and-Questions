
class node {
    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class palindrome {
    // check whether a linked list is palindrome or not by not using extra space
    public static node reverselist(node head) {
        if (head == null || head.next == null){
            return head;
            }
            node newhead = reverselist(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }

    public static node findmiddle(node head) {
        node hare = head;
        node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next; // jumps by 2 steps
            turtle = turtle.next; // jumps by 1 step

        }
        return turtle; // middle of linked list
    }

    public static boolean ispalindrome(node head) {
        if (head == null || head.next == null) {
            return true;
        }
        node middle = findmiddle(head); // 1st half ka end
        node secondHalfStart = reverselist(middle.next);
        node firstHalfStart = head;
        while (secondHalfStart != null) {
            if (firstHalfStart.data != secondHalfStart.data) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }
public static void printLinkedList(node head) {
        node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
       node head = new node(1);
        head.next = new node(5);
        head.next.next = new node(2);
        head.next.next.next = new node(5);
        head.next.next.next.next = new node(1);

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

