
public class bitmanipulation {
    public static void main(String args[]) {
        int n = 5; // 0101
        int pos = 3;
        int bitMask = 1 << pos;

        // setting bit
        int newNumber = bitMask | n;
        System.out.println(newNumber);

        // getting bit
        if ((bitMask & n) == 0) {
            System.out.println("bit was zero");
        } else {
            System.out.println("bit was one");
        }

        // clear bit
        int newBitMask = ~(bitMask);
        newNumber = newBitMask & n;
        System.out.println(newNumber);

        // update bit
        // Scanner sc = new Scanner(System.in);
        // int oper = sc.nextInt();
        // oper=1 -> set; oper=0 -> clear

    }
}
