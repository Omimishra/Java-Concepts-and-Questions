package stack.monotonic_stack;
import java.util.*;
public class max_rec_matrix {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length; //column
        int n = matrix.length; // row 
        int maxA =0;
        int psum[][] = new int[n][m];
        for(int j =0;j<m;j++){
            int sum =0;
            for(int i = 0;i<n;i++){
                sum += Character.getNumericValue(matrix[i][j]);
                if(matrix[i][j] == '0') sum=0;
                psum[i][j] = sum;
            }
        }
        for(int i =0;i<n;i++){
            maxA = Math.max(maxA,largestRectangleArea(psum[i]));
        }
        return maxA;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i = 0;i<n;i++){
            while(!st.isEmpty()&& (heights[st.peek()]>heights[i])){
            int ele = heights[st.peek()];
            st.pop();
            int nse = i;
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea,ele*(nse-pse-1));
        }
        st.push(i);
    }
    while(!st.isEmpty()){
         int ele = heights[st.peek()];
            st.pop();
            int nse = n;
            int pse = st.empty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, ele * (nse - pse - 1));
    }
    return maxArea;
    }
    public static void main(String args[]) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        max_rec_matrix obj = new max_rec_matrix();
        System.out.println("The largest area in the matrix is " + obj.maximalRectangle(matrix));
    }
    // Output: The largest area in the matrix is 6
}
