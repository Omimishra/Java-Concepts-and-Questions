package stack.notations;
import java.util.*;
public class PostfixToPrefix {
    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<=postfix.length()-1;i++){
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
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
