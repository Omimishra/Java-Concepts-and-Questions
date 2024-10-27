
public class removecycle {
    node head;
    class node {
        node next;
        int data;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

     public void addLast(int data) {
        node  newnode = new node (data);

        if (head == null) {
            head = newnode;
        }
        node  currNode = head;
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

        node  currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "->");
            currNode = currNode.next;
        }

        System.out.println("NULL");

    }

    public void removeloop(node head) {
        node hare = head;
        node turtle = head;
        node prev = null;
        node ptr = head;
        while (hare != null && hare.next != null) {
            hare.next = hare.next.next;
            prev = turtle;
            turtle.next = turtle.next;
        }
        if (turtle == hare) {
            ptr = ptr.next;
            prev = turtle;
            turtle = turtle.next;
        }
        prev.next = null;
        return;
    }
    public static void main(String[] args) {
        removecycle list = new removecycle();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.removeloop(list.head);
        list.printlist();
}
}
