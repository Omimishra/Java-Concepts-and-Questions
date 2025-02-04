package arrays.medium;

public class set_0_matrix {
    public static int[][] change(int A[][])    {
        int m = A.length;
        int n = A[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i] == 1 || col[j] == 1) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
    public static void main(String[] args) {
        int A[][] = {
            {1, 0, 1},
            {1, 1, 1},
            {1, 1, 1}
        };
        int ans[][] = change(A);
        for(int i = 0; i < ans.length; i++) {
            for(int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
        }
}
