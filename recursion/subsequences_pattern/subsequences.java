package subsequences_pattern;

public class subsequences {
    public static void subs(String str, int i, String str1) {
        if (i == str.length()) {
            System.out.println(str1);
            return;
        }
        char currchar = str.charAt(i);

        // choice of char to be in string
        subs(str, i + 1, str1 + currchar);

        // choice of char not to be in string
        subs(str, i + 1, str1);
    }

    public static void main(String[] args) {
        String str = "aaa";
        subs(str, 0, " ");
    }
}
// time complexity of this is 2^n