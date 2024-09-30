package recursion;

import java.util.HashSet;

public class uniquesubsequence {
    public static void subs(String str, int i, String str1,HashSet<String> set) {
        if (i == str.length()) {
            if(set.contains(str1)){
                return;
            }
            else{
                System.out.println(str1);
                set.add(str1);
                return;
            }
        }
        char currchar = str.charAt(i);

        // choice of char to be in string
        subs(str, i + 1, str1 + currchar,set);

        // choice of char to be in string
        subs(str, i + 1, str1,set);
    }

    public static void main(String[] args) {
        String str = "aaa";
        HashSet<String> set= new HashSet<>();
        subs(str, 0, " ",set);
    }
}

