package recursion;

public class fibonacci {
    public static void printfib(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c;
        c = a + b;
        System.out.println(c);
        printfib(b, c, n - 1);
    }

    public static void main(String args[]) {
        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);
        int n = 7;
        printfib(0, 1, n - 2);

    }
}
