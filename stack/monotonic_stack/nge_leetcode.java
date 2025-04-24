package stack.monotonic_stack;
import java.util.*;
// for next greater element in normal array 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
// Output: [-1,3,-1]
public class nge_leetcode {
    public int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int num:nums2) {
            while (!st.isEmpty() && num >= st.peek())
               map.put(st.pop(),num);
            st.push(num);
        }
        for(int i =0;i<nums1.length;i++){
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
