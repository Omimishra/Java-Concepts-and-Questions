package recursion;

public class keypadcombination {
    public static String keypad[] = { ".", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz" };

    public static void printkeypadcombination(String n, int i, String res) {
        if (i == n.length()) {
            System.out.println(res);
            return;
        }
        for (int j = 0; j < keypad[n.charAt(i) - '0'].length(); j++) {
            char curr = keypad[n.charAt(i) - '0'].charAt(i);
            printkeypadcombination(n, i + 1, res + curr);
        }
    }

    public static void main(String[] args) {
        String n = "23";
        printkeypadcombination(n, 0, " ");
    }
}
