package strings.medium;

public class longest_palindrome_substring {
    public String longestPalindrome(String s) {
        if(s.length()<=1){
            return s;
        }
        String maxStr = s.substring(0,1);
        for (int i =0;i<s.length();i++){
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);
            if(odd.length() > maxStr.length())
            maxStr = odd;
            if(even.length() > maxStr.length())
            maxStr = even;
        }
        return maxStr;
    }
    private String expand(String s, int left,int right){
        while(left>=0 && right< s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public static void main(String[] args) {
        longest_palindrome_substring obj = new longest_palindrome_substring();
        String s = "babad";
        String result = obj.longestPalindrome(s);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}