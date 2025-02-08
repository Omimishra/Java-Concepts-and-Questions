package arrays.medium;
import java.util.*;
public class longest_consecutive_seq {
    public int longestConsecutive(int[] nums) {
    Arrays.sort(nums);
    int max = 0;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
        if(nums[i]== nums[i-1]) continue; // to skip duplicate elements
        else if (nums[i]== nums[i - 1]+1) {
            count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                }
                }
                return Math.max(max, count);
            }
    public int optimal(int[] nums) {
    HashSet<Integer> num = new HashSet<>();
    for(int i =0;i<nums.length;i++){
        num.add(nums[i]);
    }
    int max = 0;
    for(int i : num){
        if(!num.contains(i-1)){ //check if the current number is start of sequence
        int count = 1;
        while(num.contains(i+count))
        count++;
        max = Math.max(max,count);
        }
    }
        return max;
        }
    public static void main(String[] args) {
        longest_consecutive_seq lcs = new longest_consecutive_seq();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(lcs.longestConsecutive(nums)); // Output: 4 (sequence: 1, 2, 3, 4)
    }
}

