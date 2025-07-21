package hard;

import java.util.ArrayList;
import java.util.List;
// Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

public class add_op_exp {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num==null||num.length()==0) return res;
        helper(res,"",num,target,0,0,0);
        return res;
    }
    public void helper(List<String>res,String path,String num,int target,int pos,long eval,long mul){
        if(pos==num.length()){
            if(target==eval)
            res.add(path);
            return;
        }
        for(int i =pos;i<num.length();i++){
       if(i!=pos&&num.charAt(pos)=='0') break;
            long curr = Long.parseLong(num.substring(pos,i+1));
            if(pos==0){
                helper(res,path+curr,num,target,i+1,curr,curr);
            }
            else
            {
                helper(res,path+"+"+curr,num,target,i+1,eval+curr,curr);
                helper(res,path+"-"+curr,num,target,i+1,eval-curr,-curr);
                helper(res,path+"*"+curr,num,target,i+1,eval-mul+mul*curr,mul*curr);
            }
        }
    }
    public static void main(String[] args) {
        add_op_exp a = new add_op_exp();
        String num = "123";
        int target = 6;
        List<String> result = a.addOperators(num, target);
        for (String expression : result) {
            System.out.println(expression);
        }
    }
}
