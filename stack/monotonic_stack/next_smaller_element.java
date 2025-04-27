package stack.monotonic_stack;
import java.util.Stack;
// for next smaller element in normal array
public class next_smaller_element {
    public int[] nextSamllerElement(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] <= st.peek())
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();

            st.push(nums[i]);
        }
        return res;
    }
public static void main(String[] args) {
        next_smaller_element obj = new next_smaller_element();
        int nums[] = { 5,7,1,2,6,0 };
        int res[] = obj.nextSamllerElement(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
