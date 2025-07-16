//time complexity is o(n*n!) where n is no of char in string and n! is permutational combination.
public class backtracking {
    public static void printpermutation(String str, String p) {
        if (str.length() == 0) {
            System.out.println(p);
            return;
        }
        for (int j = 0; j < str.length(); j++) {
            char curr = str.charAt(j);
            String newstr = str.substring(0, j) + str.substring(j + 1);
            printpermutation(newstr, p + curr);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        printpermutation(str, " ");
    }
}
