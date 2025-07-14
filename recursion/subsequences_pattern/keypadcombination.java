package recursion.subsequences_pattern;

import java.util.ArrayList;
import java.util.List;

public class keypadcombination {
   public List<String> letterCombinations(String digits) {
        String map[]={" "," ","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        StringBuilder sb = new StringBuilder();
        helper(digits,map,res,0,sb);
        return res;
    }
    private void helper(String digits,String[] map,List<String> res,int ind , StringBuilder sb){
        if(ind ==digits.length()){
        res.add(sb.toString());
        return;
        }
        String letters=map[digits.charAt(ind)-'0'];
        for (int i =0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            helper(digits,map,res,ind+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        String n = "23";
        keypadcombination k = new keypadcombination();
        List<String> ans = k.letterCombinations(n);
        System.out.println("The combinations are: " + ans);
    }
}
