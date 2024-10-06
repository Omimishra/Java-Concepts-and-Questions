import java.util.Scanner;

public class binarytodecimal {

    String decimaltobinary(long n) {
        long temp = n;
        String b = " ";
        while (temp > 0) {
            if ((temp & 1) == 1) // 1
                b = '1'+b;
            else // 0
                b = '0'+b;
            temp = temp >> 1; // Right Shift by 1
        }
        return b;
    }

    public void bintodecimal(int s) {
       int sum=0;
        int c = 0;
        int i = 0;
        while (s > 0) {
            c = (s & 1) * (int) Math.pow(2, i);
            sum=sum+c;
            s = s >> 1;
            i++;
        }
        System.out.println(sum);
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("enter a binary number");
        // int s = sc.nextInt();
        // binarytodecimal ob = new binarytodecimal();
        // ob.bintodecimal(s);
        
        System.out.println("enter a decimal number");
        long n = sc.nextLong();
        binarytodecimal ob = new binarytodecimal();
        String B = ob.decimaltobinary(n);
            System.out.print(B);

    }

}
