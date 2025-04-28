package stack.monotonic_stack;

import java.util.Stack;

public class sum_ranges {
    public int[] findNSE(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findPSE(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findNGE(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return res;
    }

    public int[] findPGE(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return res;
    }

    public int sumSubarrayMin(int[] arr) {
        int n = arr.length;
        long res = 0;
        long mod = 1000000007;
        int left = 0;
        int right = 0;
        int nse[] = findNSE(arr); // next smaller element
        int pse[] = findPSE(arr); // previous smaller element
        for (int i = 0; i < n; i++) {
            left = i - pse[i];
            right = nse[i] - i;
            res = (res + (long) arr[i] * left * right) % mod;
        }
        return (int) res;
    }
    public int sumSubarrayMax(int[] arr) {
        int n = arr.length;
        long res = 0;
        long mod = 1000000007;
        int left = 0;
        int right = 0;
        int nge[] = findNGE(arr); // next greater element
        int pge[] = findPGE(arr); // previous greater element
        for (int i = 0; i < n; i++) {
            left = i - pge[i];
            right = nge[i] - i;
            res = (res + (long) arr[i] * left * right) % mod;
        }
        return (int) res;
    }
    public long sum_subarray_ranges(int arr[]) {
        long sum = 0;
        long mod = 1000000007;
        long min_sum = sumSubarrayMin(arr);
        long max_sum = sumSubarrayMax(arr);
        sum = (max_sum - min_sum + mod) % mod;
        return sum;
    }
    public static void main(String[] args) {
        sum_ranges obj = new sum_ranges();
        int arr[] = {4,-2,-3,4,1};
        long res = obj.sum_subarray_ranges(arr);
        System.out.println(res); // Output: 4
    }
}
