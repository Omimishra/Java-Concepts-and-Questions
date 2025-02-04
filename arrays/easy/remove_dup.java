package arrays.easy;

import java.util.*;

public class remove_dup {
    public static int remove_hash(int arr[]) {
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }

    static int remove(int[] arr) {
        int k = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) { //unique element
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 4, 2, 4, 2, 1, 7, 4 };
        // int n = remove_hash(arr);
        int n = remove(arr);
        System.out.println(n);
        System.out.println("array after removing duplicates");
        for (int i=0;i<n;i++){
        System.out.print(arr[i]+" ");
        }

    }
}
