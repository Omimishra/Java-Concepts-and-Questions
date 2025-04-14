package stack.learning;

import java.util.Stack;

public class check_balanced_brackets {
    public static boolean isBalanced(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char it = str.charAt(i);
            if (it == '{' || it == '[' || it == '(') {
                s.push(it);
            } else {
                if (s.isEmpty())
                    return false;
                char ch = s.pop();
                if ((ch == '{' && it == '}') || (ch == '[' && it == ']') || (ch == '(' && it == ')'))
                    continue;
                else
                    return false;
            }
        }
        if (s.isEmpty())
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
