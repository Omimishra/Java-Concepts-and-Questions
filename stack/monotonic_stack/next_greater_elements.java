package stack.monotonic_stack;

import java.util.Stack;
//for next greater element in normal array
public class next_greater_elements {
    public int[] nextGreaterElement(int[] nums2) {
        int res2[] = new int[nums2.length];
        Stack<Integer> st = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums2[i] >= st.peek())
                st.pop();
            if (st.isEmpty())
                res2[i] = -1;
            else
                res2[i] = st.peek();

            st.push(nums2[i]);
        }
        return res2;
    }
    public int[] nge_circular_arr(int[] nums){
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2*n-1; i >=0; i--) {
            while (!st.isEmpty() && nums[i % n] >= st.peek())
                st.pop();
                if(i < n) {
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            }
            st.push(nums[i % n]);
        }
        return res;
    }

    public static void main(String[] args) {
        next_greater_elements obj = new next_greater_elements();
        int nums2[] = { 5,7,1,2,6,0 };
        int res2[] = obj.nge_circular_arr(nums2);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }
}
