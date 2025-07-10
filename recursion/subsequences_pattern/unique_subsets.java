package recursion.subsequences_pattern;
import java .util.*;

public class unique_subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        generate(result,new ArrayList<>(),nums,0);
        return result;

    }
    public void generate(List<List<Integer>> result, List<Integer> tempList, int[] nums, int i){
        result.add(new ArrayList<>(tempList));
        for(int j =i;j<nums.length;j++){
            if(j!=i && nums[j]==nums[j-1]) continue; // skip duplicates
            tempList.add(nums[j]);
            generate(result,tempList,nums,j+1);
            tempList.remove(tempList.size()-1); // backtrack
        }
    }
static void printAns(List <List<Integer>>  ans) {
    System.out.println("The unique subsets are ");
    System.out.println(ans.toString().replace(","," "));
}
public static void main(String[] args) {
    unique_subsets obj = new unique_subsets();
    int[] nums = {1, 2, 2};
    List<List<Integer>> ans = obj.subsetsWithDup(nums);
    printAns(ans);  
}
}
