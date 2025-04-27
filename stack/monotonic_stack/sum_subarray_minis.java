package stack.monotonic_stack;
import java.util.Stack;
public class sum_subarray_minis {
    public int sumSubarrayMin(int[] arr) {
        int n = arr.length;
        long res = 0;
        long mod = 1000000007;
       int left =0; int right=0;
       int nse[] = findnse(arr); // next smaller element
       int pse[] = findpse(arr); // previous smaller element
for(int i = 0; i < n; i++){
        left = i - pse[i]; // number of elements on left side of i which are greater than arr[i]
        right = nse[i] - i; // number of elements on right side of i which are greater than arr[i]
        res = (res + (long)arr[i] * left * right) % mod; // adding the product of arr[i] and number of elements on left and right side of i which are greater than arr[i]
    }
        return (int)res; // returning the result as int
    }
    public int[] findnse(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.isEmpty())
                res[i] = n;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public int[] findpse(int arr[]) {
        int n = arr.length;
        int res[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()])
                st.pop();
            if (st.isEmpty())
                res[i] = -1;
            else
                res[i] = st.peek();
            st.push(i);
        }
        return res;
    }
    public static void main(String[] args) {
        sum_subarray_minis obj = new sum_subarray_minis();
        int arr[] = {3,1,2,4};
        int res = obj.sumSubarrayMin(arr);
        System.out.println(res); // Output: 17
}
}

