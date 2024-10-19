package queue;

public class linkedlist_q {
    static class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class queue {
        static node head = null;
        static node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static void add(int data) {
            node newnode = new node(data);
            // 1st element
            if (tail == null) {
                tail = head = newnode;
            }
            tail.next = newnode;
            tail = newnode;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            int front = head.data;

            // single element condition
            if (head == tail) {
                tail = null;
            }

            head = head.next;

            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty Queue");
                return -1;
            }
            return head.data;
        }

        public static void main(String[] args) {
            @SuppressWarnings("unused")
            queue q = new queue();
            queue.add(1);
            queue.add(2);
            queue.add(3);
            queue.add(4);
            queue.add(5);
            while (!queue.isEmpty()) {
                System.out.println(queue.peek());
                queue.remove();
            }
        }
    }
}
