import java.util.*;

class hourglass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = 6;
        int columns = 6;
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the elements of the Matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        int sum = 0, max = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                sum = (matrix[i][j] + matrix[i][j + 1] + matrix[i][j + 2]) + (matrix[i + 1][j + 1])
                        + (matrix[i + 2][j] + matrix[i + 2][j + 1] + matrix[i + 2][j + 2]);

                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println("The maximum sum in the hourglass is: " + max);
        scan.close();
    }
}
