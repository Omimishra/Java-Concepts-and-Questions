package binarySearch;
public class findFirst_Last {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = findFirst(nums,n,target);
        int last = findLast(nums,n,target);
        return new int[]{first,last};
    }
    private int findFirst(int[]nums,int n, int x){
        int low=0,high=n-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==x){
                first = mid;
                high=mid-1;
            }
            else if(nums[mid]<x){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return first;
    }
    private int findLast(int[]nums,int n, int x){
        int low=0,high=n-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==x){
                last = mid;
                low=mid+1;
            }
            else if(nums[mid]>x){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return last;
    }
}
