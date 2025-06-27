package recursion.basic;

public class atoi {
    public int getNum(String s , int i,int sign,long res ){
        if(i>=s.length()|| !Character.isDigit(s.charAt(i))){
            return (int) res*sign;
        }
        res = res * 10 + (s.charAt(i) - '0');
        if(res*sign > Integer.MAX_VALUE)
        return Integer.MAX_VALUE;
        if(res*sign < Integer.MIN_VALUE)
        return Integer.MIN_VALUE;
        return getNum(s,i+1,sign,res);
    }
     public int myAtoi(String s) {
        s = s.trim();
        if(s.isEmpty())
        return 0;
        int i = 0;
        int sign = 1;
        if(s.charAt(i)=='-'){
            sign = -1;
            i++;
        }
        else if(s.charAt(i)=='+'){
            i++;
        }
         // If the first non-space character is not a digit, return 0
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return 0;
        }
        // Find the first non-digit or end of string, then call getNum
        return getNum(s, i, sign, 0);
        }
         public static void main(String[] args) {
        atoi a = new atoi();
        System.out.println(a.myAtoi("   -42abc")); // -42
        System.out.println(a.myAtoi("4193 with words")); // 4193
        System.out.println(a.myAtoi("words and 987")); // 0
        System.out.println(a.myAtoi("-91283472332")); // -2147483648
        System.out.println(a.myAtoi("21474836460")); // 2147483647
     }
    }

