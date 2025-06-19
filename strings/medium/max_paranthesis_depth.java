package strings.medium;
public class max_paranthesis_depth {
    public int maxDepth(String s) {
        int c = 0;
        int maxCount = 0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '(')
            c++;
            else if(s.charAt(i) == ')')
            c--;
            maxCount = Math.max(maxCount,c);
        }
        return maxCount;
    }
    public static void main(String[] args) {
        max_paranthesis_depth obj = new max_paranthesis_depth();
        String s = "(1+(2*3)+((8)/4))+1"; // Example input
        int result = obj.maxDepth(s);
        System.out.println(result); // Output: 3
    }
    
}
