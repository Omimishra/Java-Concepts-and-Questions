package binarySearch;
// Problem Statement: Given an array of length N. Peak element is defined as the element greater than both of its neighbors. Formally, if 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
public class peak_element {
    public static int findPeakElement(int arr[]) {
        int n = arr.length;
        if (n == 1)
            return 0; // If only one element, return index 0
        if (arr[0] > arr[1])
            return arr[0]; // If first element is a peak
        if (arr[n - 1] > arr[n - 2])
            return arr[n - 1]; // If last element is a peak
            
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            // Check if mid is a peak element
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid; // Mid is a peak

            }
            // If we are in the left:
            if (arr[mid] > arr[mid - 1])
                low = mid + 1;

            // If we are in the right:
            // Or, arr[mid] is a common point:
            else
                high = mid - 1;
        }
        return -1; // This line should never be reached if input is valid
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int peakIndex = findPeakElement(arr);
        System.out.println("The peak element is at index: " + peakIndex + " with value: " + arr[peakIndex]);
    }
}
