import java.util.*;

class powerof2 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");// program to find out if the number is power of 2 or not
        int n = sc.nextInt();
        int c = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                c++;
            }
            n = n >> 1;
        }
        if (c == 1) {
            System.out.println("Number is a power of two");
        } else {
            System.out.println("Number is not a power of two");
        }
    }
}
