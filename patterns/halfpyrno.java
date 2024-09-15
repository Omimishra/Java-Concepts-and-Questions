package patterns;

class halfpyrno {
    public static void main(String[] args) {
        int n = 5;// HALF PYRAMID BY NUMBERS
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println("");
        }
    }
}