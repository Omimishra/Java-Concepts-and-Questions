package patterns;
class pattern12 {
    public static void main(String[] args) {
        // butterfly pattern
        int n = 5;
        // upper half
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // first half
                System.out.print("*");
            }
            int sp = 2 * (n - i);
            for (int k = 1; k <= sp; k++) {
                // spaces
                System.out.print(" ");

            }
            for (int o = 1; o <= i; o++) {
                // second half
                System.out.print("*");
            }
            System.out.println("");
        }
        // lower part
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                // first half
                System.out.print("*");
            }
            int sp = 2 * (n - i);
            for (int k = 1; k <= sp; k++) {
                // spaces
                System.out.print(" ");

            }
            for (int o = 1; o <= i; o++) {
                // second half
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
