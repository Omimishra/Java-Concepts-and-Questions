public class duplicates {
    public static boolean map[] = new boolean[26];

    public static void removeduplicates(String str, int i, String newString) {
        if (i == str.length()) {
            System.out.println(newString);
            return;
        }

        char curchar = str.charAt(i);
        if (map[curchar - 'a'] == true) {
            removeduplicates(str, i + 1, newString);

        } else {
            newString = newString + curchar;
            map[curchar - 'a'] = true;
            removeduplicates(str, i + 1, newString);
        }
    }

    public static void main(String[] args) {
        String str = "abbccda";
        removeduplicates(str, 0, " ");
    }

}
// time complexity o(n)