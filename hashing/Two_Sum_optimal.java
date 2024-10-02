package hashing;

import java.util.*;

public class Two_Sum_optimal {
    public int[] twoSum(int[] nums, int target) {
        // pointers approach O(n)
        // int i = 0;
        // int j = nums.length-1;
        // while(i<j){
        // int pairsum=nums[i]+nums[j];
        // if(pairsum>target){
        // j--;
        // }
        // else if(pairsum< target){
        // i++;
        // }
        // else
        // return new int[]{i,j};
        // }
        // return null;
        // }
        // hashmap approach O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                if (map.get(complement) == i)
                    continue;
                return new int[] { i, map.get(complement) };
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Two_Sum_optimal sc = new Two_Sum_optimal();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = sc.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
