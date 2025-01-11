package arrays;
public class Repeating_missing {

    public static int[] brute_force(int[] [] a) {
        int n = a.length; // size of the array
        int repeating = -1, missing = -1;

        //Find the repeating and missing number:
        for (int k = 1; k <= n*n; k++) {
            //Count the occurrences:
            int cnt = 0;
            for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == k) cnt++;
            }
        }

            if (cnt == 2) repeating = k;
            else if (cnt == 0) missing = k;

            if (repeating != -1 && missing != -1)
                break;
        }
        int[] ans = {repeating, missing};
        return ans;
    }

    public static void main(String[] args) {
        int a[][] = {{9,1,7},{8,9,2},{3,4,6}};
        int[] ans = brute_force(a);
        System.out.println("The repeating and missing numbers are: {"
                           + ans[0] + ", " + ans[1] + "}");
    }
}



