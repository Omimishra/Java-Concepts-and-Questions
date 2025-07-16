package basic;

public class count_good_nos {
    public long MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        
        long even = (n+1)/2;
        long odd = n/2;

        long pow5 = Power(5,even);
        long pow4 = Power(4,odd);

        return (int) ((pow5 *pow4) % MOD);
    }
    public long Power(long base,long exp){
        if(exp == 0) return 1;
// Recursively calculate x^(n/2)
        long temp = Power(base,exp/2);
        // If n is even, return (x^(n/2))^2
        if(exp%2==0)
        return (temp*temp) % MOD;
        else
        // If n is odd, return (x^(n/2))^2 * x
        return (base*temp*temp) % MOD;

    }
    public static void main(String[] args) {
        count_good_nos obj = new count_good_nos();
       System.out.println(obj.countGoodNumbers(5));

    }
}
