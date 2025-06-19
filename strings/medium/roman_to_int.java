package strings.medium;

public class roman_to_int {
     public int romanToInt(String s) {
        int ans = 0, num = 0,prev=0;
        for(int i =s.length()-1;i>=0;i--){
            switch(s.charAt(i)){
                case 'I':
                num=1; break;
                case 'V':
                num=5; break;
                case 'X':
                num=10; break;
                case 'L':
                num=50; break;
                case 'C':
                num=100; break;
                case 'D':
                num=500; break;
                case 'M':
                num=1000; break;
            }
            // If the current numeral is less than the previous one, we subtract it; otherwise, we add it.
            if(num<prev)
            ans -= num;
            else
            ans+=num;
            prev=num;
        }
        return ans;
    }
    public static void main(String[] args) {
        roman_to_int obj = new roman_to_int();
        String s = "LVIII"; // Example input
        int result = obj.romanToInt(s);
        System.out.println(result); // Output: 1994
    }
}
