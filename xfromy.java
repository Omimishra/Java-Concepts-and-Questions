import java.util.Scanner;

public class xfromy {
    private static int calculate(String x, String y, String reversedy, int index, int county, int countReversedy, int S, int R, int minFactor) {
        if (index == x.length()) {
            return county * S + countReversedy * R;
        }
        int curr = Integer.MAX_VALUE;
        for (int i = index + 1; i <= x.length(); i++) {
            String substring = x.substring(index, i);
            if (y.contains(substring)) {
                curr = Math.min(curr, calculate(x, y, reversedy, i, county + 1, countReversedy, S, R, minFactor));
            }
        }
        for (int j = index + 1; j <= x.length(); j++) {
            String substring = x.substring(index, j);
            if (reversedy.contains(substring)) {
                curr = Math.min(curr, calculate(x, y, reversedy, j, county, countReversedy + 1, S, R, minFactor));
            }
        }
        return curr;
    }

    public static int minimum_string_factor(String x, String y, int S, int R) {
        String reversedy = new StringBuilder(y).reverse().toString();
        return calculate(x, y, reversedy, 0, 0, 0, S, R, Integer.MAX_VALUE);
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