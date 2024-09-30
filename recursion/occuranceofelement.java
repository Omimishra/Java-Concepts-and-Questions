package recursion;

public class occuranceofelement {
    public static int first = -1;
    public static int last = -1;

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
