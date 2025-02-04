package arrays.medium;

public class max_subarray_sum {
    
public static int maxSum(int arr[]){
    int n = arr.length;
    int max_sum = Integer.MIN_VALUE;
    int current_sum = 0;
    for (int i = 0;i<n;i++)
    {
        current_sum = current_sum + arr[i];
        max_sum = Math.max(current_sum,max_sum);
        if (current_sum < 0)
        current_sum = 0;
        }
        return max_sum;
    }

public static void main(String[] args) {
    int arr[] = {3,-4,5,4,-1,7,-8};
    int ans= maxSum(arr);
    System.out.println("Maximum sum of subarray is: "+ans);
}
}

