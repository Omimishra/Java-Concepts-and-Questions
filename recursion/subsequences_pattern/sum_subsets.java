package subsequences_pattern;

import java.util.ArrayList;
import java.util.Collections;
//  Given an array print all the sum of the subset generated from it, in the increasing order.
public class sum_subsets {
     static ArrayList < Integer > subsetSums(ArrayList < Integer > arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        helper(ans,N,0,arr,0);
        Collections.sort(ans);
        return ans;
     }
     static void helper(ArrayList<Integer> ans,int N,int i,ArrayList<Integer> arr,int sum){
        if(i==N){
            ans.add(sum);
            return;
        }
        helper(ans,N,i+1,arr,sum+arr.get(i)); // include the current element
        helper(ans,N,i+1,arr,sum); // exclude the current element
     }
     public static void main(String[] args) {
      ArrayList<Integer> arr = new ArrayList<>();
      arr.add(1);
      arr.add(2);
      arr.add(3);
      int N = arr.size();
      ArrayList<Integer> ans = subsetSums(arr, N);
      System.out.println("The sum of all subsets is: " + ans);
      
     }
}
