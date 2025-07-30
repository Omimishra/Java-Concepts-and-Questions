package binarySearch;
public class upper_bound {
    public static int lowerBound(int []arr, int n, int x) {
        int low = 0; int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>x){
            ans = mid;
            ////look for smaller index on the left
            high = mid-1;
            }
            else {
                //look in the right half
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
