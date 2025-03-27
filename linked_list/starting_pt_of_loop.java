public class starting_pt_of_loop {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node firstNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        starting_pt_of_loop list = new starting_pt_of_loop();
        Node node1 = list.new Node(1);
        Node node2 = list.new Node(2);
        node1.next = node2;
        Node node3 = list.new Node(3);
        node2.next = node3;
        Node node4 = list.new Node(4);
        node3.next = node4;
        Node node5 = list.new Node(5);
        node4.next = node5;

        // Make a loop from node5 to node2
        node5.next = node2;

        // Set the head of the linked list
        Node head = node1;
        Node loopStartNode = firstNode(head);
        if (loopStartNode != null) {
            System.out.println("Loop detected. Starting node of the loop is: " + loopStartNode.data);
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
