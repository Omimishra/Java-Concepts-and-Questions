package binarySearch;
public class search_dup_rotated {
    public static boolean searchInARotatedSortedArrayII(int []arr, int k) {
        int n = arr.length;
        int low=0;
        int high=n-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] == k) {
                return true; // Target found
            }
            if (arr[mid]==arr[low] && arr[mid]== arr[high]){
                low=low+1; // Skip duplicates
                high=high-1;
                continue;
            }
            if (arr[low] <= arr[mid]) {
                //sorted left half
                if(arr[low]<=k && k<arr[mid]){
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }
            else{
                //sorted right half
                if(arr[mid]<k && k<=arr[high]){
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }
        return false; // Target not found
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = searchInARotatedSortedArrayII(arr, target);
        if(result) {
            System.out.println("Target found");
        } else {
            System.out.println("Target not found");
        }
    }
}
