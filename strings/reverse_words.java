package strings;
public class reverse_words {
    public String reverseWords(String s) {
        // String[] words = s.split(" ");
        String [] words = s.trim().split("\\s+"); // Split by whitespace and trim leading/trailing spaces
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        reverse_words obj = new reverse_words();
        String s = "Hello World";
        String result = obj.reverseWords(s);
        System.out.println(result); // Output: World Hello
    }
}
// public String reverseWords(String s) {
//         String[] words = s.split(" ");
//         StringBuilder result = new StringBuilder();
//         for (String word : words) {
//             result.append(word).append("\n");
//         }
//         return result.toString();
//     }