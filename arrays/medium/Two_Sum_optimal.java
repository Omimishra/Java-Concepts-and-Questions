package hashing;
import java.util.*;
public class Two_Sum_optimal {
    public int[] twoSum(int[] nums, int target) {
        // hashmap approach O(n)
        int ans[] = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
               ans[0] = map.get(complement);
               ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);

        }
        return ans;
    }
    public static void main(String[] args) {
        Two_Sum_optimal sc = new Two_Sum_optimal();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = sc.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
