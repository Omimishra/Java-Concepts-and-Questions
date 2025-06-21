package strings.hard;

public class repeat_string_match {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder repeatA = new StringBuilder(a);
        int c = 1;
        while(repeatA.length()<b.length()){
            repeatA.append(a);
            c++;
        }
        if(repeatA.toString().contains(b)) 
            return c;
        if(repeatA.append(a).toString().contains(b)) 
            return ++c;
        return -1;
    }
    public static void main(String[] args) {
        repeat_string_match r = new repeat_string_match();
        String a = "abcd"; // Example input
        String b = "cdabcdab"; // Example input 
        int result = r.repeatedStringMatch(a, b);
        System.out.println("The minimum number of times string a must be repeated to contain string b is: " + result);
    }
}
