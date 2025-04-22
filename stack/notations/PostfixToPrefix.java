package stack.notations;
import java.util.*;
public class PostfixToPrefix {
    public static String convert(String postfix) {
        // This method converts a postfix expression to a prefix expression.
        // It uses a stack to store the operands and operators.
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<=postfix.length()-1;i++){
            // For each character in the postfix expression, check if it is an operand or operator.
            // If it is an operand, push it onto the stack.
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{// If it is an operator, pop the top two operands from the stack, combine them with the operator, and push the result back onto the stack.
                // The order of operands is important for prefix notation.
                String t1 = stack.pop();
                String t2 = stack.pop();
                stack.push(ch+t2+t1);
            }
        }
        return stack.pop();
}
    public static void main(String[] args) {
        String postfix = "ABCD/-*";
        System.out.println(convert(postfix)); // ((A-B)/(C*D))
    }
}
