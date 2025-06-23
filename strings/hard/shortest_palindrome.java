package strings.hard;
public class shortest_palindrome {
    private int[] computeLPS(String pattern){
    int lps[] = new int[pattern.length()];
    int i = 0,j=1;
    while(j<pattern.length()){
        if(pattern.charAt(i) == pattern.charAt(j)){
            lps[j] =i+1;
            i++;
            j++;
        }
        if(j==pattern.length())
        break;
        if(pattern.charAt(i)!=pattern.charAt(j)){
            if(i>0)
            i=lps[i-1];
            else{
                lps[j]=0;
                j++;
            }
        }
    }
        return lps;
}
    public String shortestPalindrome(String s) {
        if(s == null || s.length()<=1)
        return s;
        // Reverse the original string
        String reversed = new StringBuilder(s).reverse().toString();
         // Create a new string with a separator '#' to avoid overlap confusion
        String combined = s + "*" + reversed;
        int lps[] = computeLPS(combined);
        // The length of the longest palindromic prefix in original string
        int prefixlen = lps[lps.length-1];
        // Get the suffix (part of s that is not in the palindrome prefix)
        String suffix = s.substring( prefixlen);

         // Reverse the suffix and prepend it to the original string
         
        StringBuilder result = new StringBuilder(suffix).reverse().append(s);
        return result.toString();
    }
}
