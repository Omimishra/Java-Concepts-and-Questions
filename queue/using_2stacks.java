package queue;

import java.util.Stack;

public class using_2stacks {
    static class queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;

            }
            return s1.pop();
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;

            }
            return s1.peek();
        }
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
