import java.util.*;

class fac {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number ");
        int n = sc.nextInt();
        factorial(n);
    }

    public static void factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }

        System.out.println("the fatorial of the number is " + f);

    }
}
