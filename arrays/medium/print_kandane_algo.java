package arrays.medium;

public class print_kandane_algo {
    public static void print(int arr[]){
        int n = arr.length;
        int max_sum = Integer.MIN_VALUE;
        int curr_sum = 0;
        int start=0;
        int end =0;
        for(int i =0;i<n;i++){
            curr_sum+=arr[i];
            if(curr_sum>max_sum){
                max_sum = curr_sum;
                end = i;//until we get the maximum sum from 0th index to ith index start=0 and end=i
            }
            if(curr_sum<0){//when we get negative sum we reset the sum and start from next index
                curr_sum = 0;
                start = i+1;
            }
        }
        System.out.println("Maximum sum of subarray is: "+max_sum);
        System.out.println("Subarray is: ");
        for(int i = start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        print(arr);

    }
    
}
