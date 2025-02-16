package arrays.hard;
import java.util.ArrayList;
public class reverse_pairs {
//brute force approach
    // public static int countPairs(int[] a, int n) {

    //     // Count the number of pairs:
    //     int cnt = 0;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             if (a[i] > 2 * a[j])
    //                 cnt++;
    //         }
    //     }
    //     return cnt;
    // }
     private static void merge(int[] arr, int low, int mid, int high) {//merges two sorted halves of the array.
        ArrayList<Integer> temp = new ArrayList<>(); 
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {//it iterates through the left half of the array and for each element, it finds how many elements in the right half satisfy the condition.
        //The count is accumulated in cnt and returned.
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * arr[right]) right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public static int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
//         It recursively divides the array into two halves until each half contains a single element.
// It counts the reverse pairs in each half using the countPairs function.
// It merges the two halves using the merge function.
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); 
        merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

    public static int reversePairs(int[] nums) {
       return mergeSort(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        int[] a = {4, 1, 2, 3, 1};
        int cnt = reversePairs(a);
        System.out.println("The number of reverse pair is: " + cnt);
    }
}  

