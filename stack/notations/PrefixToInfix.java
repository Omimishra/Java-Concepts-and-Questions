package stack.notations;
import java.util.Stack;

public class PrefixToInfix {
    static String preToInfix(String pre_exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for(int i = pre_exp.length()-1;i>=0;i--){
            char ch = pre_exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            stack.push(String.valueOf(ch));
            else{
                String t1 = stack.pop();
                String t2 = stack.pop();
                stack.push("("+t1+ch+t2+")");
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String pre_exp = "*-A/BC-/AKL";
        System.out.println(preToInfix(pre_exp)); // ((A-B)/(C*D))
    }
}
