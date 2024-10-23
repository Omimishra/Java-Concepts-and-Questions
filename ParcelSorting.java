import java.util.Arrays;
import java.util.Scanner;

public class ParcelSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading input
        int n = sc.nextInt(); // Number of boxes
        int k = sc.nextInt(); // Position of Head Post Master's office (1-based index)
        k--; // Convert to 0-based index
        
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        // Step 1: Find the heaviest box
        int maxWeightIndex = 0;
        for (int i = 1; i < n; i++) {
            if (weights[i] > weights[maxWeightIndex]) {
                maxWeightIndex = i;
            }
        }

        // Step 2: Move the heaviest box to the required position k
        int totalEffort = 0;

        // Swapping to bring the heaviest box to position k
        while (maxWeightIndex != k) {
            if (maxWeightIndex < k) {
                // Swap with the next element
                totalEffort += weights[maxWeightIndex] * weights[maxWeightIndex + 1];
                swap(weights, maxWeightIndex, maxWeightIndex + 1);
                maxWeightIndex++;
            } else {
                // Swap with the previous element
                totalEffort += weights[maxWeightIndex] * weights[maxWeightIndex - 1];
                swap(weights, maxWeightIndex, maxWeightIndex - 1);
                maxWeightIndex--;
            }
        }

        // Step 3: Sort the remaining elements except the heaviest one at position k
        int[] toSort = new int[n - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) {
                toSort[index++] = weights[i];
            }
        }
        
        // Using Arrays.sort() to sort in O(N log N)
        Arrays.sort(toSort);
        
        // Step 4: Reinsert sorted elements back into the array, skipping the heaviest position
        index = 0;
        for (int i = 0; i < n; i++) {
            if (i != k) {
                weights[i] = toSort[index++];
            }
        }

        // Calculate the effort for sorting (sorting itself does not count towards effort)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (j == k || j + 1 == k) {
                    continue; // Skip the heaviest element
                }
                if (weights[j] > weights[j + 1]) {
                    totalEffort += weights[j] * weights[j + 1];
                    swap(weights, j, j + 1);
                }
            }
        }

        // Output the total effort
        System.out.println(totalEffort);
    }

    // Utility function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
