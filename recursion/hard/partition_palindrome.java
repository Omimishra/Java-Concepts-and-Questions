package hard;

import java.util.ArrayList;
import java.util.List;

public class partition_palindrome {
    // Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),0,s);
        return res;
    }
    private static void helper(List<List<String>> res, List<String> path,int ind , String s){
        if(ind==s.length())
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i =ind;i<s.length();i++){
            if(ispalindrome(s,ind,i)){
                path.add(s.substring(ind,i+1));
                helper(res,path,i+1,s);
                path.remove(path.size()-1);
            }
        }
    }
    private static boolean ispalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--))
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        partition_palindrome pp = new partition_palindrome();
        String s = "aab";
        List<List<String>> result = pp.partition(s);
        System.out.println("All possible palindrome partitions: " + result);
    }
}
