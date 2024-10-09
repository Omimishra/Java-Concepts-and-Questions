package stack;

public class basic_ll {
    static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class stack {
        public static node head;

        public static boolean isempty() {
            return head == null;
        }

        public static void push(int data) {
            node newnode = new node(data);
            if (isempty()) {
                head = newnode;
                return;
            }
            newnode.next = head;
            head = newnode; // newnode will become head
        }

        public static int pop() {
            if (isempty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isempty()) {
                return -1;
            }
            return head.data;

        }

    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
        stack s = new stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isempty()) {
            System.out.println(stack.peek());
            stack.pop();

        }
    }
}
