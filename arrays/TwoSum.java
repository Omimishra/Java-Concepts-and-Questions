package arrays;
import java.util.*;
public class TwoSum {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

    public static void main(String[] args) {
        TwoSum sc = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = sc.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
        }
    }
    

