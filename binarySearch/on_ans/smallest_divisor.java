package binarySearch.on_ans;

public class smallest_divisor {
    public static int divide(int arr[], int div) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double) arr[i] / (double) div);
        }
        return sum;
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length;
        if (n > limit)
            return -1; // If the number of elements is greater than the limit, return -1

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]); // Find the maximum element in the array
        }
        int low = 1;
        int high = max;
        while (low <= high) {

            int mid = (low + high) / 2;
            if (divide(arr, mid) <= limit) {
                high = mid - 1; // If the sum of divisions is within the limit, try smaller divisor
            } else {
                low = mid + 1; // If the sum exceeds the limit, try larger divisor
            }
        }
        return low; // 'low' will be the smallest divisor that meets the condition
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 5, 9 };
        int limit = 6;
        int result = smallestDivisor(arr, limit);
        System.out.println("The smallest divisor is: " + result);
    }
}
