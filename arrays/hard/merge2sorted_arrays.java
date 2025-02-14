package arrays.hard;

import java.util.Arrays;

public class merge2sorted_arrays {
    public static void merge(int[] nums1, int[] nums2, int n, int m) {
        // used when two different arrays are given as output
        // n = 4, arr1[] = [1 3 5 7]
        // m = 5, arr2[] = [0 2 6 8 9]
        // Output:
        // arr1[] = [0 1 2 3]
        // arr2[] = [5 6 7 8 9]
        int left = n - 1;
        int right = 0;// left is the last element of the first array and right is the first element of
                      // the second array
        while (left >= 0 && right < n) {
            // Swap the elements until arr1[left] is
            // smaller than arr2[right]:
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else
                break;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }

    public static void merged(int[] nums1, int[] nums2, int n, int m) {
        // used when only first array (merged) is given as output
        // nums1 = [1,2,3,0,0,0], n = 3, nums2 = [2,5,6], m = 3
        // Output: [1,2,2,3,5,6]
        int i = n - 1, j = m - 1, k = n + m - 1;
        while (i >= 0 && j >= 0) {
            // This loop compares elements from the end of nums1 and nums2 and places the larger element at the end of the merged array in nums1.
            // It decrements the respective indices (i, j, k) accordingly.
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            k--;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 8, 10 };
        int[] arr2 = { 2, 3, 9 };
        int n = 4, m = 3;
        merge(arr1, arr2, n, m);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

}
