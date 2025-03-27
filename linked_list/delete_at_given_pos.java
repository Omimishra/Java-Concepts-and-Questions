
public class delete_at_given_pos {
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node constructLL(int arr[]) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node currNode = head;
        for (int i = 1; i < arr.length; i++) {
            currNode.next = new Node(arr[i]);
            currNode.next.prev = currNode;
            currNode = currNode.next;
        }
        return head;
    }

    public Node deleteNode(Node head, int x) {
        // If the position to delete is the head node
        if (x == 1) {
            if (head == null || head.next == null) {
                return null; // If the list is empty or has only one node, return null
            }
            Node newhead = head.next;
            newhead.prev = null;
            head.next = null;
            return newhead;
        }
        Node current = head;
        for (int i = 1; i < x; i++) {
            current = current.next;
        }
        // If the node to delete is the tail node
        if (current.next == null) {
            Node temp = current.prev;
            temp.next = null;
            current.prev = null;
            return head;
        }
        // If the node to delete is in the middle
        Node previous = current.prev;
        Node after = current.next;
        previous.next = after;
        after.prev = previous;
        return head;
    }

    public static void main(String[] args) {
        delete_at_given_pos obj = new delete_at_given_pos();
        int arr[] = { 1, 2, 3, 4, 5 };
        Node head = obj.constructLL(arr);
        // one based indexing
        // head = obj.deleteNode(head, 2);
        head = obj.deleteNode(head, 1);// head
        // head = obj.deleteNode(head, 5);//tail
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "<->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }
}
