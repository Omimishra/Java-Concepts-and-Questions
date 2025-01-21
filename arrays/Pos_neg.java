package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Pos_neg {
    public static int[] segregate(int arr[], int n) {
        int pos[] = new int[n];
        int neg[] = new int[n];
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            // entering the positive and negative elements in the respective arrays
            if (arr[i] >= 0) {
                pos[j] = arr[i];
                j++;
            } else {
                neg[k] = arr[i];
                k++;
            }
        }
        // merging the positive and negative arrays
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i % 2 == 0) {
                arr[i] = pos[p];
                p++;
            } else {
                arr[i] = neg[q];
                q++;
            }
        }
        return arr;
    }

    public static int[] RearrangebySign(int[] A, int n) {

        // Define 2 vectors, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (A[i] >= 0)
                pos.add(A[i]);
            else
                neg.add(A[i]);
        }
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                A[i] = pos.get(i / 2);
            else
                A[i] = neg.get(i / 2);
        }
        return A;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        int pindex = 0, nindex = 1;
        for (int i = 0; i < n; i++) {
            if (A.get(i) < 0) {
                ans.set(nindex, A.get(i));
                nindex = nindex + 2;
            } else {
                ans.set(pindex, A.get(i));
                pindex = pindex + 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, -3, -1, -2, 3 };
        // int n = arr.length;
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -3, -1, -2, 3));
        ArrayList<Integer> ans = optimized(A);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        // int res[] = RearrangebySign(arr, n);
        // for (int i = 0; i < n; i++) {
        //     System.out.print(res[i] + " ");
        }
    }

