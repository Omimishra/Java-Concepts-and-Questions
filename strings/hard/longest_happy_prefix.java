package strings.hard;
public class longest_happy_prefix {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix suffix
        int i = 1; // Start from the second character
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // Use the previous longest prefix suffix
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return s.substring(0, lps[lps.length - 1]);
    }
    public static void main(String[] args) {
        longest_happy_prefix lhp = new longest_happy_prefix();
        String s = "level"; // Example input
        String result = lhp.longestPrefix(s);
        System.out.println("The longest happy prefix of \"" + s + "\" is: \"" + result + "\"");
    }
}
