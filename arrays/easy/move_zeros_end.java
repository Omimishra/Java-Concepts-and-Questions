package arrays.easy;

import java.util.*;

public class move_zeros_end {
    public static int[] func(int arr[], int n) {
        ArrayList<Integer> temp = new ArrayList<>();
        // copy non zero elements
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }
        // filling non-zero elements in original array
        int k = temp.size();
        for (int i = 0; i < k; i++) {
            arr[i] = temp.get(i);
        }

        // filling empty spaces with zeros
        for (int i = k; i < n; i++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static int[] func2(int a[], int n) {
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0){
                j = i;
                break;
            }
        }
        if (j == -1)
            return a;
        for (int i = j + 1; i < n; i++) {
            if (a[i] != 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j++;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 2, 0, 0, 4, 5, 1 };
        int n = 10;
        int[] ans = func2(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }
}
