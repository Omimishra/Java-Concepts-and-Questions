import java.util.*;
class arr1 {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int size = sc.nextInt();
        System.out.println("enter nummbers of array");
        int num[] = new int[size];
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            num[i] = sc.nextInt();
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max)
                max = num[i];
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        System.out.println("minimium number in array is " + min);
        System.out.println("maximium number in array is " + max);

    }
}
