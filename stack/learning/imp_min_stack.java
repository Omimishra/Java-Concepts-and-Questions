package stack.learning;
import java.util.Stack;
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    class MinStack {
        Stack < Pair > st;
        public MinStack() {
            st = new Stack < > ();
        }
    
        public void push(int x) {
            int min;
            if (st.isEmpty()) {
                min = x;
            } else {
                min = Math.min(st.peek().y, x);
            }
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
