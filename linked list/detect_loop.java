public class detect_loop {
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public boolean hasCycle(node head) {
        if (head == null || head.next == null) {
            return false;
        }
        node hare = head;
        node turtle = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
            if (hare == turtle) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        detect_loop loop = new detect_loop();
        node head = loop.new node(1);
        node second = loop.new node(2);
        node third = loop.new node(3);
        node fourth = loop.new node(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;
        System.out.println(loop.hasCycle(head));
    }
}
