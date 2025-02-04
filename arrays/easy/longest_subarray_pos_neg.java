package arrays.easy;

import java.util.HashMap;
// Length of longest subarray when it contains both positive and negative elements
public class longest_subarray_pos_neg {
    public static int lenOfLongSubarr(int a[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == k) {
                maxlen = Math.max(maxlen, i + 1);
            }
            int rem = sum - k;
            if (map.containsKey(rem)) {
                int l = i - map.get(rem);
                maxlen = Math.max(maxlen, l);
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
return maxlen;
    }
    public static void main(String[] args) {
        int[] a = { -1, 1, 1};
        int k = 1;
        int n = a.length;
        int len = lenOfLongSubarr(a,n, k);
        System.out.println("The length of the longest subarray is: " + len);
    }

}
