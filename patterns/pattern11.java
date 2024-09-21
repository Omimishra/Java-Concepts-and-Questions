package patterns;

class pattern11 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            // outer loop
            for (int j = n - i; j >= 1; j--) {
                // first spaces
                System.out.print(" ");
            }
            // first part
            for (int k = i; k >= 1; k--) {
                System.out.print(k);
            }
            // second part
            for (int o = 2; o <= i; o++) {
                System.out.print(o);
            }

            System.out.println(" ");
        }
    }
}