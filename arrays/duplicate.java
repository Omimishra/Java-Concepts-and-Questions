package arrays;
import java.util.Arrays;

public class duplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 1 };
        boolean ans = containsDuplicate(arr);
        System.out.println(ans);
    }

    public static boolean containsDuplicate(int[] arr) { //time complexity O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }
        public boolean containDuplicate(int[] nums) { //time complexity O(n log n)
            Arrays.sort(nums);
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1])
                    return true;
            }
            return false;
        }
    }

