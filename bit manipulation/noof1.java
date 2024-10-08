import java.util.Scanner;

public class noof1 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");// program to find out if the number of 1 in binary representation
        int n = sc.nextInt();
        int c = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                c++;
            }
            n = n >> 1;
        }
        System.out.println("Number of 1's in the binary representation of the number is " + c);
    }

}
