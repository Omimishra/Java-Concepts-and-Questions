package binarySearch;

public class floor_ceil {
    static int findFloor(int[] arr, int n, int x) {
        int low = 0, high = n - 1, floor = -1;
        while(low<=high){
            int mid = (low+high)/2;
             if (arr[mid] <= x) {
                floor = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return floor;
    }
    static int findCeil(int[] arr, int n, int x) {
        int low = 0, high = n - 1, ceil = -1;
        while(low<=high){
            int mid = (low+high)/2;
             if (arr[mid] >= x) {
                ceil = arr[mid];
                //look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ceil;
    }
     public static int[] getFloorAndCeil(int[] arr, int n, int x) {
        int f = findFloor(arr, n, x);
        int c = findCeil(arr, n, x);
        return new int[] {f, c};
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 4, 5, 6};
        int x = 4;
        int n = arr.length;
        int[] result = getFloorAndCeil(arr, n, x);
        System.out.println("The floor of " + x + " is: " + result[0]);
        System.out.println("The ceil of " + x + " is: " + result[1]);
    }
}
