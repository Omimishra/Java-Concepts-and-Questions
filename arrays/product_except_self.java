package arrays;

public class product_except_self {
    public static int[] brute(int[] nums) {
        int n = nums.length;
        int [] ans= new int [n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(i!=j)
                ans[i] *= nums[j];
            }
        }
        return ans;
        }
        public static int[] optimal(int[]nums){
            int n = nums.length;
            int [] ans = new int[n];
            ans[0] = 1;
            for(int i =1;i<n;i++){//calculating left product(prefix)
                ans[i] = ans[i-1]*nums[i-1];
            }
            int right = 1;
            for(int i = n-1;i>=0;i--){
                ans[i] *= right;
                right *= nums[i];
            }
            return ans;
        }
}
