package binarySearch;

public class single_element {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0]; // If only one element, return it
        if(nums[0] != nums[1]) return nums[0]; // If first element is unique
        if(nums[n-1] != nums[n-2]) return nums[n-1]; // If last element is unique
        int low=1;
        int high=n-2;
        while(low<=high){
            int mid = (low+high)/2;
            // Check if mid is the unique element
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            if((mid % 2==1 && nums[mid] == nums[mid-1])|| (mid % 2==0 && nums[mid] == nums[mid+1])) {
                // If mid is odd and equals to previous or mid is even and equals to next
                // then the unique element is in the right half
                low = mid + 1;
            } else {
                // Otherwise, the unique element is in the left half
                high = mid - 1;
            }
        }
        return -1; // This line should never be reached if input is valid
    }
    public static void main(String[] args) {
        single_element se = new single_element();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int uniqueElement = se.singleNonDuplicate(nums);
        System.out.println("The single non-duplicate element is: " + uniqueElement);
    }
}
