package subsequences_pattern;

import java.util.ArrayList;
import java.util.List;

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
// Each number in candidates may only be used once in the combination.
// Note: The solution set must not contain duplicate combinations.
public class unique_combination_sum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates,new ArrayList<>(),ans,0,target);
        return ans;
    }
    private void helper(int arr[],List<Integer> ds, List<List<Integer>> ans,int i ,int target){
         if(target==0){
                ans.add(new ArrayList<>(ds));
            return;
            }
            //we need to skip the duplicates
            for(int j=i;j<arr.length;j++){
                if(j>i && arr[j]==arr[j-1]) continue; // skip duplicates
                if(target-arr[i]==0) break; // no need to continue if the current number exceeds the target
                ds.add(arr[j]);
                helper(arr,ds,ans,j+1,target-arr[j]); // move to the next index
                ds.remove(ds.size()-1); // backtrack
            }
    }
}
