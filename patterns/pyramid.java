package patterns;

class pattern10 {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            // outer loop
            for (int j = n - i; j >= 1; j--) {
                // first spaces
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(i + " ");
            }

            System.out.println(" ");
        }
    }
}