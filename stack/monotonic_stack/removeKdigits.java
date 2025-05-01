package stack.monotonic_stack;
import java.util.*;
class removeKdigits {
    public String removedigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<num.length();i++){
            char digit = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }
        while(k>0){//numbers are in ascending order
            st.pop();
            k--;
        }
        if(st.empty())
        return "0";
        StringBuilder s = new StringBuilder();
        while(!st.isEmpty()){
            s.append(st.pop());//poping out digits from stack
        }
        s.reverse();//reversing it to form smallest number
        while(s.length()>1 && s.charAt(0) == '0'){//removing leading zeros
            s.deleteCharAt(0);
        }
        return s.toString();
    }
    public static void main(String args[]) {
        removeKdigits obj = new removeKdigits();
        String num = "1432219";
        int k = 3;
        System.out.println("The smallest number after removing " + k + " digits is: " + obj.removedigits(num, k));
    }
    // Output: "1219"
}