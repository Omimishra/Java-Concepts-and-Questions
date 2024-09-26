package recursion;

// no of ways in which you can invite n people to your party , single or in pairs
public class pairing {
    public static int callguests(int n) {
        if (n <= 1)
            return 1;

        int way1 = callguests(n - 1);
        int way2 = (n - 1) * callguests(n - 2);
        return way1 + way2;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(callguests(n));
    }
}
