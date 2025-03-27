public class hare_turtle {
    // head is given and we have to determine if the linkedlist has a cycle or not.
    // this also called as floyd's algo
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

    public boolean hasCycle(node head) {
        if (head == null) {
            return false;
        }
        node hare = head;
        node turtle = head;

        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;

            if (hare == turtle)
                return true;

        }
        return false;
    }

    public static void main(String[] args) {
        hare_turtle list = new hare_turtle();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        boolean ans = list.hasCycle(list.head);
        System.out.println(ans);
    }
}
