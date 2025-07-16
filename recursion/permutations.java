import java.util.ArrayList;
public class permutations {
    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        backtrack(res, tempList, nums);
        return res;
    }
    public static void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {//if tempList is equal to the length of the array then add it to the result it means we have found one permutation
            res.add(new ArrayList<>(tempList));
            return;
        } 
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {//if the tempList does not contain the element then add it to the tempList and backtrack
                    tempList.add(nums[i]);
                    backtrack(res, tempList, nums);
                    tempList.remove(tempList.size() - 1);//remove the last element from the tempList
                }
            }
        }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        ArrayList<ArrayList<Integer>> res = permute(nums);
        System.out.println(res);
    }

}
