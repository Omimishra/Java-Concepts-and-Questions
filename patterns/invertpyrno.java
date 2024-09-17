package patterns;

class invertpyrno {
    public static void main(String[] args) {
        int n = 5;
        // inverted pyramid by numbers
        // for(int i = 1; i <= n; i++) {
        // for (int j = 1; j <= n-i+1;j++){
        // System.out.print(j);
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <=i; j++) {
                System.out.print(j);
            }
            System.out.println("");
        }
    }
}