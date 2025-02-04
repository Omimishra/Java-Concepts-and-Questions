package arrays.easy;

import java.util.*;

public class union {
    public static ArrayList<Integer> findUnion(int a[], int b[], int n, int m) {
        ArrayList<Integer> union = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != a[i])
                    union.add(a[i]);
                i++;
            }
            else{
                if (union.size() == 0 || union.get(union.size() - 1) != b[j])
                    union.add(b[j]);
                j++;
            }
        }

        while (i<n){
            if (union.get(union.size() - 1) != a[i])
                    union.add(a[i]);
                i++;
        }
        while (j<m){
            if (union.get(union.size() - 1) != b[j])
                    union.add(b[j]);
                j++;
        }
        return union;
    }

    public static void main(String[] args) {
        int n = 10,m=8;

        int a[] = {1,2,3,4,5,6,7,8,9,10};
        int b[] = {2,4,6,8,10,12,14,17};
        ArrayList<Integer> ans = findUnion(a, b, n, m);
        System.out.println("Union of a and b array is ");
        for(int v:ans){
            System.out.print(v+" ");
        }
    }
}
