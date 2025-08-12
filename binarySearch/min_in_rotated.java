package binarySearch;

public class min_in_rotated {
     public static int findMin(int []arr) {
        int low =0;
        int high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(arr[low] <= arr[high]) {
                ans = Math.min(ans,arr[low]); // Array is already sorted
                break;
            }
            if(arr[low]<=arr[mid]) {
                ans = Math.min(ans, arr[low]); // Left half is sorted
                low = mid + 1; // eliminate left half
            } else {
                ans = Math.min(ans, arr[mid]); // Right half is sorted
                high = mid - 1; // eliminate right half
            }
     }
     return ans; // Minimum element found
}
public static void main(String[] args) {
    int[] arr = {3, 4, 5, 1, 2};
    int minElement = findMin(arr);
    System.out.println("Minimum element in the rotated sorted array: " + minElement);
}
}
