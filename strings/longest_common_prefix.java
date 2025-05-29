package strings;

import java.util.Arrays;

public class longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        longest_common_prefix obj = new longest_common_prefix();
        String[] strs = {"flower", "flow", "flight"};
        String result = obj.longestCommonPrefix(strs);
        System.out.println(result); // Output: "fl"
    }
}
