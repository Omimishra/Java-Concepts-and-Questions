package arrays.hard;

public class max_product_subarray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            // If the current element nums[i] is negative, the values of max and min are swapped. This is because multiplying by a negative number will make the maximum product the minimum and vice versa.
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            // max is updated to be the maximum of the current element nums[i] and the product of max and nums[i]
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
