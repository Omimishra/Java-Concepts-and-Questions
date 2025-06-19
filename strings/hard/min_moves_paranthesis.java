package strings.hard;

public class min_moves_paranthesis {
    public int minAddToMakeValid(String s) {
        int openBrackets = 0;
        int minMovesRequired = 0;
        for (int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
            openBrackets++;
            }
            else
            {
                if(openBrackets>0){
                openBrackets--;
                }
                else{
                minMovesRequired++;
        }
            }
    }
    return openBrackets+minMovesRequired;
}
    public static void main(String[] args) {
        min_moves_paranthesis obj = new min_moves_paranthesis();
        String s = "())"; // Example input
        int result = obj.minAddToMakeValid(s);
        System.out.println(result); // Output: 1
    }
}
