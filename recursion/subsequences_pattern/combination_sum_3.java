package subsequences_pattern;

import java.util.ArrayList;
import java.util.List;

public class combination_sum_3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(),n,k,1);
        return ans;
    }
    private void helper(List<List<Integer>> ans,List<Integer> ds, int n,int k ,int start){
        if(k==0 && n==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = start;i<=9;i++){
            if(i<=n && k>0){
                ds.add(i);
                helper(ans,ds,n-i,k-1,i+1);
                ds.remove(ds.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        combination_sum_3 obj = new combination_sum_3();
        int k = 3, n = 7;
        List<List<Integer>> ans = obj.combinationSum3(k, n);
        System.out.println("The combinations are: " + ans);
    }
}
