package subsequences_pattern;

import java.util.ArrayList;
import java.util.List;

public class generate_paranthesis {
     public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList <>();
        helper(0,0,"",n,res);
        return res;
    }
    public void helper(int openP,int closeP,String s,int n,List<String> res){
        if(openP==closeP && openP+closeP == n*2){
            res.add(s);
            return;
        }
        if(openP<n){
            helper(openP+1,closeP,s+"(",n,res);
        }
        if(closeP<openP){
            helper(openP,closeP+1,s+")",n,res);
        }
    }
    public static void main(String[] args) {
        generate_paranthesis gp = new generate_paranthesis();
        List<String> result = gp.generateParenthesis(3);
        System.out.println(result); // Output: [((())), (()()), (())(), ()(()), ()()()]
    }
}
