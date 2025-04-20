package stack.notations;
import java.util.Stack;
public class prefixToPostfix {
    public static String pretopost(String str){
        Stack<String> stack = new Stack<>();
        for(int i =str.length()-1;i>=0;i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(str.charAt(i)+"");
            }
            else{
                String t1 = stack.pop();
                String t2 = stack.pop();
                stack.push(t1+""+t2+ch);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String str = "*-A/BC-/AKL";
        System.out.println(pretopost(str)); // ((A-B)/(C*D))
    }
}
