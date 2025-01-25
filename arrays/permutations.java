package arrays;

import java.util.ArrayList;

public class permutations {
    public static ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }
    public static void backtrack(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> tempList, int[] nums)
    {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!tempList.contains(nums[i])) {
                    tempList.add(nums[i]);
                    backtrack(res, tempList, nums);
                    tempList.remove(tempList.size() - 1);
                    }
                    }
                    }
                    }
                    public static void main(String[] args) {
                        int nums[] = {1, 2, 3};
                        ArrayList<ArrayList<Integer>> res = permute(nums);
                        System.out.println(res);
                    }
                    
}
