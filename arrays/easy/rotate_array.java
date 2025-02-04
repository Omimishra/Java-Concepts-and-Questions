package arrays;

public class rotate_array {
    // not for edge cases
    // public static void rotate(int[] nums, int k) {

    // for (int i=0;i<k;i++){
    // int temp = nums[nums.length-1];
    // for (int j=nums.length-1;j>0;j--){
    // nums[j] = nums[j-1];
    // }
    // nums[0] = temp;
    // }
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0)
            return;
        k = k % n;
        if (k > n)
            return;

        int temp[] = new int[k];
        for (int i = n - k; i < n; i++) { // creating temporary array of k size
            temp[i + k - n] = nums[i];
        }
        for (int i = n - k - 1; i >= 0; i--) { // shifting elements to right
            nums[i + k] = nums[i];
        }
        for (int i = 0; i < k; i++) { // copying elements from temp array to nums
            nums[i] = temp[i];
        }
    }
//optimized code
    public static void rotate_arr(int[] nums, int k) {
        k = k % nums.length;
        int n = nums.length;
        // Reverse first n-k elements
        reverse(nums, 0, n - k - 1);
        // Reverse last k elements
        reverse(nums, n - k, n - 1);
        // Reverse whole array
        reverse(nums, 0, n - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate_arr(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
