package stack.learning;

import java.util.Stack;

public class check_balanced_brackets {
    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char it = str.charAt(i);
            if (it == '{' || it == '[' || it == '(') {
                // push the opening brackets onto the stack
                s.push(it);
            } else {
                if (s.isEmpty())
                // if the stack is empty and we encounter a closing bracket, return false
                    return false;
                char ch = s.pop();
                // check if the popped character matches the current closing bracket
                // if it does, continue to the next iteration
                if ((ch == '{' && it == '}') || (ch == '[' && it == ']') || (ch == '(' && it == ')'))
                    continue;
                else
                // if it doesn't match, return false
                    return false;
            }
        }
        if (s.isEmpty())
        // if the stack is empty after processing all characters, return true
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        String str = "{[()]}";
        if (isBalanced(str)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }
}
