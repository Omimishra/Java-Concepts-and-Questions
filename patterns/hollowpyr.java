package patterns;

class hollowpyr {
    public static void main(String[] args) {
        int n = 4;
        
        // hollow pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 || j == 1 || j==i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

    }
}