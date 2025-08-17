package binarySearch;

public class times_rotated {
    public static int findKRotation(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int ans = Integer.MAX_VALUE;
        int index=-1;
        while(low<=high) {
            int mid = (low+high)/2;
            if(arr[low]<=arr[high]) {
                ans = Math.min(ans, low); // Array is already sorted
                index = low;
                break;
            }
            if (arr[mid] >= arr[low]) {
               ans = Math.min(ans, arr[low]); // Left half is sorted
               index = low;
            low = mid + 1; // eliminate left half
                
            } else {
                ans = Math.min(ans, arr[mid]); // Right half is sorted
                index = mid;
                high = mid - 1; // eliminate right half
            }

        }
        return index; // Number of rotations
    }
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int rotations = findKRotation(arr);
        System.out.println("Number of times the array is rotated: " + rotations);
    }
    
}
