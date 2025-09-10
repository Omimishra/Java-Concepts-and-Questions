package binarySearch.on_ans;

public class split_array {
     public static int countPartitions(int[] a, int maxSum) {
        int partitions = 1; // Start with one partition
        int currentSum = 0;
        for (int num : a) {
            if (currentSum + num <= maxSum) {
                currentSum += num; // Add to current partition
            } else {
                partitions++; // Need a new partition
                currentSum = num; // Start new partition with current number
            }
        }
        return partitions;
}
public static int splitArray(int[] a, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : a) {
            low = Math.max(low, num); // The largest single element
            high += num; // Sum of all elements
        }
        while (low <= high) {
            int mid = (high + low) / 2;
            if (countPartitions(a, mid) <= k) {
                high = mid +1; // Try for a smaller maximum sum
            } else {
                low = mid + 1; // Increase the maximum sum
            }
        }
        return low; // This is the minimum largest sum possible
    }

    public static void main(String[] args) {
        int[] a = {7, 2, 5, 10, 8};
        int k = 2;
        int result = splitArray(a, k);
        System.out.println("The minimum largest sum for " + k + " subarrays is: " + result);
    }
}
