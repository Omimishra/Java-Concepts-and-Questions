package arrays.easy;
public class Count_max_1 {

    public static int count_max_1(int[] a) {
        int n = a.length;
        int max_1 = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                cnt++;
            } else {
                cnt = 0;
            }
            max_1 = Math.max(max_1, cnt);
        }
        return max_1;
    }
    public static void main(String[] args) {
        int [] a = {1, 1, 0, 1, 0, 1, 0, 0, 1};
    int result = count_max_1(a);
    System.out.println(result);
}
}
