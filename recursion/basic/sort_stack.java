package basic;

import java.util.Stack;

public class sort_stack {
    public static void sorted_stack(Stack<Integer> s, int x) {
        if (s.isEmpty()|| x > s.peek()) {
            s.push(x);
            return;
        } 
            int a = s.pop();
            sorted_stack(s, x);
            s.push(a);
        
    }

    public static Stack<Integer> sort(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int x = s.pop();
            sort(s);
            sorted_stack(s, x);
        }
        return s;
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        // Pushing elements to the stack: 4 3 2 1 (bottom to top)
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        // Sorting the stack
        sort(s);

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
