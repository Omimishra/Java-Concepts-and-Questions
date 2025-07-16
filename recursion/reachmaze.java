// time complexity o(2^(m+n))
public class reachmaze {
    public static int countpath(int i, int j, int n, int m) {
        if (i == n || j == m) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        // move downwards
        int downpaths = countpath(i + 1, j, n, m);
        // move rightwards
        int rightpaths = countpath(i, j + 1, n, m);
        return downpaths + rightpaths;
    }

    public static void main(String[] args) {
        int totalpaths = countpath(0, 0, 3, 4);
        System.out.println(totalpaths);
    }
}
