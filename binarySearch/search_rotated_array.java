package binarySearch;

public class search_rotated_array {
    public static int search(int nums[],int target){
        int low = 0, high= nums.length - 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[low]<=nums[mid]){
                // Left half is sorted
                if(nums[low]<=target && target<nums[mid]){
                    high = mid - 1; // Search in left half
                } else {
                    low = mid + 1; // Search in right half
                }
            }
            else
            {
                // Right half is sorted
                if(nums[mid]<target && target<=nums[high]){
                    low = mid + 1; // Search in right half
                } else {
                    high = mid - 1; // Search in left half
                }
            }
        }
        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(nums, target);
        if(result != -1) {
            System.out.println("Target found: " + result);
        } else {
            System.out.println("Target not found");
    }
    }
}
