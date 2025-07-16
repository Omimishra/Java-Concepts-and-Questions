public class newstring {
    public static void moveallx(String str, int i, int c, String str1) {
        if (i == str.length()) {
            for (int j = 0; j < c; j++) {
                str1 = str1 + 'x';
            }
            System.out.println(str1);
            return;
        }
        char currchar = str.charAt(i);
        if (currchar == 'x') {
            c++;
            moveallx(str, i + 1, c, str1);
        } else {
            str1 = str1 + currchar;
            moveallx(str, i + 1, c, str1);
        }
    }

    public static void main(String[] args) {
        String str = "axbcxxd";
        moveallx(str, 0, 0, " ");

    }
}
// time complexity o(2n).....traversing string then count loop but we can
// neglect it so it becomes O(n)
