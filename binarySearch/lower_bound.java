package binarySearch;
public class lower_bound {
    //search index ques
    // You are given a sorted array arr of distinct values and a target value x. You need to search for the index of the target value in the array.
    // If the value is present in the array, then return its index. Otherwise, determine the index where it would be inserted in the array while maintaining the sorted order.

    // write a program to find the lower bound of x.
    //both ques have same code
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0; int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>=x){
            ans = mid;
            ////look for smaller index on the left
            high = mid-1;
            }
            else {
                low = mid+1;
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6};
        int x = 4;
        int n = arr.length;
        int index = lowerBound(arr, n, x);
        System.out.println("The lower bound of " + x + " is at index: " + index);
    }
}
