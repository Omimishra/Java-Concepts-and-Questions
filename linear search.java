import java.util.*;

class arr2 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int c = 0;
        System.out.println("enter the elements of the array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("enter the number to be searched");
        int num = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                c = 1;
                System.out.println("the number is found at index number"+i ) ;
            }
        }
        if (c == 0)
            System.out.println("the number is not found");
    }
}
