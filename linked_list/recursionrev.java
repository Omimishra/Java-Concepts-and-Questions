
public class recursionrev {
    Node head;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    public void addlast(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
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
        System.out.println("Null");
    }

    public Node reverselist(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newhead = reverselist(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;

        return newhead;
    }

    public static void main(String[] args) {
        recursionrev list = new recursionrev();
        list.addlast(1);
        list.addlast(2);
        list.addlast(3);
        list.addlast(4);
        list.addlast(5);
        list.printlist();

        list.head = list.reverselist(list.head);
        list.printlist();
    }
}
