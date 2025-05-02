package stack.monotonic_stack;
import java.util.*;
public class largest_rec {

    static int largestRectangleArea(int histo[]) {
        Stack < Integer > st = new Stack < > ();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <n; i++) {
            while (!st.empty() && (histo[st.peek()] >= histo[i])) {
                int element = histo[st.peek()];
                st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                maxA = Math.max(maxA, element * (nse - pse - 1));
            }
            st.push(i);
        }
        while (!st.empty()) {
            int element = histo[st.peek()];
            st.pop();
            int nse = n;
            int pse = st.empty() ? -1 : st.peek();
            maxA = Math.max(maxA, element * (nse - pse - 1));
            
        }
        return maxA;
    }

    public static void main(String args[]) {
        int histo[] = {2,1,5,6,2,3};
        System.out.println("The largest area in the histogram is " + largestRectangleArea(histo));
    }
}

