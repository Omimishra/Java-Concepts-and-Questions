package subsequences_pattern;
import java.util.*;
public class combination_sum {
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findcombinations(new ArrayList<> (),target,0,candidates,ans);
        return ans;
    }
    public void findcombinations(List<Integer> ds,int target,int i , int arr[],List<List<Integer>> ans){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<> (ds));
            }
            return;
        }

        if(target-arr[i]>=0){
            ds.add(arr[i]);
            findcombinations(ds,target-arr[i],i,arr,ans);
            ds.remove(ds.size()-1);
        }
        findcombinations(ds,target,i+1,arr,ans);
    }
    public static void main(String[] args) {
        combination_sum cs = new combination_sum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = cs.combinationSum(candidates, target);
        System.out.println(result);
    }
}
