package stack.learning;
import java.util.Stack;
// Implement a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    class Pair {
        int x, y;
        // Constructor to initialize the Pair
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class MinStack {
        Stack < Pair > st;
        // Constructor to initialize the stack
        public MinStack() {
            st = new Stack < > ();
        }
    
        public void push(int x) {
            // create a new Pair with the current value and the minimum value
            int min;
            if (st.isEmpty()) {
                // if the stack is empty, set the minimum value to the current value
                min = x;
            } else {
                // if the stack is not empty, set the minimum value to the minimum of the current value and the top of the stack
                min = Math.min(st.peek().y, x);
            }
            // push the new Pair onto the stack
            st.push(new Pair(x, min));
        }
    
        public void pop() {
            st.pop();
        }
    
        public int top() {
            return st.peek().x;
        }
    
        public int getMin() {
            return st.peek().y;
        }
    }
    public class imp_min_stack {
        public static void main(String[] args) {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            System.out.println(minStack.getMin()); // Returns -3.
            minStack.pop();
            System.out.println(minStack.top()); // Returns 0.
            System.out.println(minStack.getMin()); // Returns -2.
        }
    }
