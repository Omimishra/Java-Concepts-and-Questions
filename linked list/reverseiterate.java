
public class reverseiterate {
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
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;

        }
        currNode.next = newNode;
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

    public void reverselist() {

        if (head == null || head.next == null) {
            return;
        }

        Node prevnode = head;
        Node currNode = head.next;

        while (currNode != null) {
            Node nextnode = currNode.next;
            currNode.next = prevnode;

            // update
            prevnode = currNode;
            currNode = nextnode;
        }
        head.next = null;
        head = prevnode;
    }

    public static void main(String[] args) {
        reverseiterate list = new reverseiterate();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printlist();

        list.reverselist();
        list.printlist();

    }
}
