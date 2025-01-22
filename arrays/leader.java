package arrays;
import java.util.*;
public class leader {
    public static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = arr[n - 1];
        res.add(max);
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                max = arr[i];
                res.add(max);
            }
        }
        Collections.reverse(res);
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        int n = arr.length;
        ArrayList<Integer> res = leaders(arr, n);
        System.out.println("Leaders in the array are:");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
