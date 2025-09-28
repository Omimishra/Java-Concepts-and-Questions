package Two_pointer;

public class max_cons_1 {

    public int longestOnes(int[] nums , int k){
        int left = 0 , right = 0;
        int n = nums.length;
        int maxLen = 0;
        int zeroCount = 0;
        int len = 0;

        while(right < n){
            if(nums[right] == 0) 
            zeroCount++;

            if(zeroCount > k){
                //shrink the window from left whenever zeroCount exceeds k
                if(nums[left] == 0) 
                zeroCount--;
                // move the left pointer ahead if num is 1 and if num is 0 then decrease the zeroCount
                left++;
            }
            if(zeroCount <= k){
                len = right - left + 1;
                maxLen = Math.max(maxLen , len);
            }
            right++;
        }
        return maxLen;
    }
    public static void main(String[] args) {
        max_cons_1 obj = new max_cons_1();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("The length of longest subarray with at most k 0's is " + obj.longestOnes(nums , k));
    }
}
