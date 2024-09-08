import java.util.*;

class fac2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number ");
        int n = sc.nextInt();
        prime(n);
    }

    public static void prime(int n) {
        int f = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                f++;
        }
        if (f == 2) {
            System.out.println(" number is prime");
        } else {
            System.out.println("number is not prime");
        }
    }
}