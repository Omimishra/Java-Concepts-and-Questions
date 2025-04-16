package stack;
import java.util.*;
public class next_greater {

    public static int[] nextGreaterElements(int[] nums) {
        // Create an array to store the next greater elements
        // Create a stack to store the indices of the elements in nums
        int n = nums.length;
        int nge[] = new int[n];
        Stack < Integer > st = new Stack < > ();
        // Traverse the array twice to find the next greater elements
        // The first loop traverses the array from the end to the beginning
        // The second loop traverses the array from the beginning to the end
        // The stack is used to keep track of the indices of the elements in nums

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
                st.pop();
            }
// If the stack is not empty, the top element is the next greater element
            // If the stack is empty, there is no next greater element
            if (i < n) {
                if (st.isEmpty() == false) nge[i] = st.peek();
                else nge[i] = -1;
            }
// Push the current element onto the stack
            st.push(nums[i % n]);
        }
        return nge;
    }
    public static void main(String args[]) {
        int arr[]={5,7,1,2,6,0};

        int arr2[] = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}

