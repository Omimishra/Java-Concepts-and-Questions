package arrays;

public class spiral_matrix {
    public void spiral(int arr[][]) {
        int n = arr.length;// no of rows
        int m = arr[0].length;// no of columns
        int top = 0, bottom = n - 1, left = 0, right = m - 1;
        while (left <= right && top <= bottom) {
            // Traverse the matrix
            for (int i = left; i <=right; i++) {
                System.out.print(arr[top][i] + " ");
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                System.out.print(arr[i][right] + " ");
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(arr[bottom][i] + " ");
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(arr[i][left] + " ");
                }
                left++;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        spiral_matrix obj = new spiral_matrix();
        int arr[][] = { { 1, 2, 3, 4 }, 
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
                obj.spiral(arr);

    }
}
