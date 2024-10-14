package arrays;

public class longest_subarray_sum {
    public static int lenOfLongSubarr(int A[], int n, int k) {
        // Only for positives
        int l = 0;
        int r = 0;
        int sum=A[0];
        int maxl = 0;
        while(r<n){
            r++;
            if(r<n){
                sum+= A[r];
            }
            
            if(sum == k){
                maxl = Math.max(maxl,r-l+1);
            }
            
            while(sum>k && l<=r){
                sum -=A[l];
                l++;
            }
            
        }
        return maxl;
    }
    public static void main(String[] args) {
        int a[] = {2, 3, 5, 1, 9};
        int k = 10;
        int n = a.length;
        int len = lenOfLongSubarr(a,n, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
    }

