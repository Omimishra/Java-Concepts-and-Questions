package queue.learning;
import java.util.Stack;
// stack implementation through 2 stacks O(1) for push and O(n) for pop and peek
public class optimised_using_2stacks {
    class queue {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        void push(int a) {
            System.out.println("pushing " + a + " in queue");
            s1.push(a);
        }
        public int pop() {
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            if (s2.isEmpty()) {// if s2 is empty, pop all elements from s1 and push them in s2
                // this way the first element of s1 will be at the top of s2 and all other
                // elements will be below it
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();// return the top element of s2
        }
        public int peek() {
            if (s1.isEmpty() && s2.isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            if (s2.isEmpty()) {// if s2 is empty, pop all elements from s1 and push them in s2
                // this way the first element of s1 will be at the top of s2 and all other
                // elements will be below it
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();// return the top element of s2
        }
        int size(){
            return s1.size() + s2.size();
        }
    }
    public static void main(String[] args) {
        optimised_using_2stacks obj = new optimised_using_2stacks();
        queue q = obj.new queue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " +q.size());
    }
}
