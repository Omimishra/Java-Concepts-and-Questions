
public class tiles {// no of ways in which tiles can be placed
    public static int placetiles(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }
        int verticalplacements = placetiles(n - m, m);
        int horizonatplacements = placetiles(n - 1, m);
        return verticalplacements + horizonatplacements;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        System.out.println(placetiles(n, m));
    }
}
