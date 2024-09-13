package patterns;
class pattern {// solid rhombus
    public static void main(String[] args) {
        int n = 4;
        for (int i = 1; i <= n; i++) {

            for (int j = n - i; j >= 1; j--) {
                // first spaces
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                // stars
                // if (i == 1 || j == 1 || j == n || i == n) for hollow rhombus
                System.out.print("*");
            }
            for (int k = 1; k <= i; k++) {
                // second spaces
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }
}