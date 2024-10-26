
public class palindrome {
    // check whether a linked list is palindrome or not by not using extra space
    node head;

    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(int data) {
        node newNode = new node(data);
        if (head == null) {
            head = newNode;
        }

        node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;

        }
        currNode.next = newNode;
    }

    public node reverseiterate(node head) {

        // node prev = head;
        // node currNode = head.next;
        node prev = null;
        node currNode = head;

        while (currNode != null) {
            node nextnode = currNode.next;
            currNode.next = prev;
            // update
            prev = currNode;
            currNode = nextnode;
        }
        // head.next = null;
        // head = prev;
        return prev;

    }

    public node findmiddle(node head) {
        node hare = head;
        node turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next; // jumps by 2 steps
            turtle = turtle.next; // jumps by 1 step

        }
        return turtle; // middle of linked list
    }

    public boolean ispalindrome(node head) {
        if (head == null || head.next == null) {
            return true;
        }
        node middle = findmiddle(head); // 1st half ka end
        node secondHalfStart = reverseiterate(middle.next);
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

    public static void main(String[] args) {
        palindrome list = new palindrome();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        boolean ans = list.ispalindrome(list.head);
        System.out.println(ans);
    }
}
