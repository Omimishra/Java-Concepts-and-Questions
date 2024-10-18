import java.util.Scanner;

public class xfrom {
    public static int minimum_string_factor(String x, String y, int S, int R) {
        int[][] dp = new int[x.length() + 1][x.length() + 1];
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= x.length(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;

        String reversedy = new StringBuilder(y).reverse().toString();

        for (int i = 1; i <= x.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = x.substring(j, i);
                if (y.contains(substring)) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[j][j] + S);
                }
                if (reversedy.contains(substring)) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[j][j] + R);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int j = 0; j <= x.length(); j++) {
            minCost = Math.min(minCost, dp[x.length()][j]);
        }

        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        int s = sc.nextInt();
        int r = sc.nextInt();
        int result = minimum_string_factor(x, y, s, r);
        System.out.println(result);
        sc.close();
    }
}