package stack.notations;
import java.util.Stack;
public class PostfixToInfix {
    public String convert(String postfix) {
       
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <= postfix.length() - 1; i++) {
            char ch = postfix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(ch + "");
            } else { // If it is an operator, pop the top two operands from the stack, combine them with the operator, and push the result back onto the stack.
                String t1 = stack.pop();
                String t2 = stack.pop();
                stack.push("(" + t2 + ch + t1 + ")");
            }
        }
        return stack.pop();
}
    public static void main(String[] args) {
        PostfixToInfix obj = new PostfixToInfix();
        String postfix = "ABCD/-*";
        System.out.println(obj.convert(postfix)); // ((A-B)/(C*D))
    }
}
