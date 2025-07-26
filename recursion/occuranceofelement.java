public class occuranceofelement {
    public static int first = -1;
    public static int last = -1;
// This code finds the first and last occurrence of a character in a string using recursion.
// It initializes two static variables, first and last, to -1. The findoccurance method is called with the string, an index starting at 0, and the character to search for.
// The method checks each character in the string recursively, updating first and last when the character is found.
// Finally, it prints the first and last occurrences of the character.
    public static void findoccurance(String str, int ind, char element) {
        if (ind == str.length()) {
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currchar = str.charAt(ind);
        if (currchar == element) {
            if (first == -1) {
                first = ind;
            } else {
                 
                    last = ind;
                }
            }
        
        findoccurance(str, ind + 1, element);
    }

    public static void main(String[] args) {
        String str = "abaacdaefaah";
        findoccurance(str, 0, 'a');
    }
}
