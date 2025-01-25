package arrays;

public class rotate_matrix_90 {
    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int result[][] = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                result[j][n-i-1] = matrix[i][j];
            }
        }
    return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int result[][] = rotate(matrix);
        for(int i =0;i<result.length;i++){
            for(int j =0;j<result.length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
}
