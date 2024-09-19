package arrays;
public class subarrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int st=0;st<arr.length;st++){
            for( int end=st;end<arr.length;end++){
                for(int i = st;i<=end;i++){
                    System.out.print(arr[i] );
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
