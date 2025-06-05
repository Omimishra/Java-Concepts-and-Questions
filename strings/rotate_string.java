package strings;

public class rotate_string {
    public static boolean checkRotate(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //after combining the same string twice we can check if the rotated string is present in it
        String combined = s + s;
        return combined.contains(t);
    }
    public static void main(String[] args) {
        String s = "abcde";
        String t = "cdeab";
        boolean result = checkRotate(s, t);
        System.out.println(result); // Output: true

        String s2 = "abcde";
        String t2 = "abced";
        boolean result2 = checkRotate(s2, t2);
        System.out.println(result2); // Output: false
    }
}
