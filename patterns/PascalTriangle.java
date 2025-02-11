package patterns;
import java.util.*;
public class PascalTriangle {//for calculating a particular element when row and column are given
    public static long ncr(int n, int r) {
        long res = 0;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }
public static List<List<Integer>> generate(int numRows) {//for generating the whole pascal triangle
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = generate(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        // int[][] arr = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j <= i; j++) {
        //         if (j == 0 || i == j) {
        //             arr[i][j] = 1;
        //         } else {
        //             arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];

        //         }
        //         System.out.print(arr[i][j] + "");
        //     }
        //     System.out.println();
        // }
    }
}
