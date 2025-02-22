package arrays.hard;
import java.util.HashMap;
public class longest_subarray_0 {
    public static int lenOfLongSubarr(int a[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlen = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == 0) {
                maxlen = Math.max(maxlen,i+1);
            }
            else{
                if(!map.containsKey(sum)){
                    map.put(sum, i);
                }
                else {
                    int l = i - map.get(sum);
                    maxlen = Math.max(maxlen, l);
                }
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] a = { 15, -2, 2, -8, 1, 7, 10, 23};
        int n = a.length;
        int len = lenOfLongSubarr(a,n);
        System.out.println("The length of the longest subarray is: " + len);
    }
    
}
