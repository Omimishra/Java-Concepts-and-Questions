package stack.monotonic_stack;
import java.util.*;
// for next greater element in normal array 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
public class nge_leetcode {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        // nums1 is the array for which we need to find the next greater element
        // nums2 is the array in which we need to find the next greater element
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int num:nums2) {
            // if stack is not empty and the current number is greater than the top of the stack
            // then we pop the stack and put the current number in the map with the popped number as key

            while (!st.isEmpty() && num >= st.peek())
               map.put(st.pop(),num);
            st.push(num);
        }
        for(int i =0;i<nums1.length;i++){
            // if the number is not in the map then we put -1 in the map for that number
            // else we put the value of the number in the map for that number
            // so that we can get the next greater element for that number in O(1) time
            nums1[i]=map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }
    public static void main(String[] args) {
        nge_leetcode obj = new nge_leetcode();
        int nums1[] = {4,1,2};
        int nums2[] = {1,3,4,2};
        int res[] = obj.nextGreaterElement(nums1,nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
