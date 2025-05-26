package strings;
public class word_extraction {
     public void wordextraction(String s ){
        char ch;
        s = s+" ";
        String word = "" ;
        for (int i = 0;i<s.length();i++){
            ch = s.charAt(i);
            if(ch!=' '){
                word = word+ch;
            }
            else 
            {
                System.out.println(word); // Reset for the next word
                word = "";
            }
        }
}
public String wordextraction2(String s ){
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(word).append("\n");
        }
        return result.toString();
    }

     public static void main(String[] args) {
         word_extraction obj = new word_extraction();
         String s = "Hello World";
            obj.wordextraction(s);
            String result = obj.wordextraction2(s);
            System.out.println(result); // Output: Hello\nWorld\n
     }
}
