package strings;
public class remove_paranthesis {
     public String removeOuterParentheses(String s) {
        int start = 0;
        int end = 0;
        int c =0;
        StringBuilder str = new StringBuilder();
        for (int i =0;i<s.length();i++){
            if(s.charAt(i)=='('){
                c++;
            }
            if(s.charAt(i)==')'){
                c--;
                if(c==0){
                    end=i;
                    str.append(s.substring(start+1,end));
                    start = ++end;
                }
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        remove_paranthesis obj = new remove_paranthesis();
        String s = "(()())(())";
        String result = obj.removeOuterParentheses(s);
        System.out.println(result); // Output: ()()()
    }
}
