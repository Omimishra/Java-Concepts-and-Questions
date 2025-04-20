package arrays;

import java.util.List;

public class diff_in_diagonals {
    public static int diagonalDifference(int arr[][]) {
        int n = arr.length;
        int leftdaigonal = 0;
        int rightdaigonal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    leftdaigonal += arr[i][j];
                }
                if (i + j == n - 1) {
                    rightdaigonal += arr[i][j];
                }
            }
        }
        return Math.abs(leftdaigonal - rightdaigonal);
    }

    public static int diagonal_Difference(List<List<Integer>> arr) {
        int n = arr.size();
        int leftdaigonal = 0;
        int rightdaigonal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    leftdaigonal += arr.get(i).get(j);
                }
                if (i + j == n - 1) {
                    rightdaigonal += arr.get(i).get(j);
                }
            }
        }
        return Math.abs(leftdaigonal - rightdaigonal);
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 9, 8, 9 } };
        System.out.println(diagonalDifference(arr)); // 2
    }
}
