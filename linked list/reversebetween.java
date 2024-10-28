public class reversebetween {
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

    public Node reverse(Node head, int left, int right) {

        Node dummy = new Node(0);
        dummy.next = head; // in case if left index is head node then we need a temp node 

        Node leftpre = dummy;
        Node curr = head;
        
        for ( int i = 0 ; i< left - 1 ; i++){
            leftpre = leftpre.next;
            curr = curr.next;
        }

        Node subhead = curr; // marker for the node where we are starting
        Node prev = null;

       for (int j = 0; j<= right - left ; j++ ){
            Node nextnode = curr.next;
            curr.next = prev;

            // update
            prev = curr;
            curr = nextnode;
        }
       leftpre.next = prev;
       subhead.next = curr;

       return dummy.next; // head
    }

    public static void main(String[] args) {
        reversebetween list = new reversebetween();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.printlist();

        list.reverse(list.head , 2,4);
        list.printlist();

    }
}
