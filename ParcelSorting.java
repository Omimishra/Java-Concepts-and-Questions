import java.util.*;

public class ParcelSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // Number of boxes
        int k = sc.nextInt(); // Position of Head Post Master's office (1-based index)
        k--; // Convert to 0-based index
        
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        
        long totalEffort = sortParcels(weights, k);
        System.out.println(totalEffort);
        
        sc.close();
    }
    
    private static long sortParcels(int[] weights, int k) {
        int n = weights.length;
        long effort = 0;
        
        // Find the heaviest and lightest boxes
        int heaviestIndex = 0;
        int lightestIndex = 0;
        for (int i = 1; i < n; i++) {
            if (weights[i] > weights[heaviestIndex]) {
                heaviestIndex = i;
            }
            if (weights[i] < weights[lightestIndex]) {
                lightestIndex = i;
            }
        }
        
        // Move heaviest box to position k
        if (heaviestIndex != k) {
            effort += moveBox(weights, heaviestIndex, k, lightestIndex);
        }
        
        // Sort the rest of the boxes
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (j == k || j + 1 == k) continue;
                if (weights[j] > weights[j + 1]) {
                    effort += moveBox(weights, j, j + 1, lightestIndex);
                }
            }
        }
        
        return effort;
    }
    
    private static long moveBox(int[] weights, int from, int to, int lightestIndex) {
        long effort = 0;
        int boxWeight = weights[from];
        int lightestWeight = weights[lightestIndex];
        
        long directEffort = (long) boxWeight * weights[to];
        long indirectEffort = (long) boxWeight * lightestWeight + 
                              (long) lightestWeight * weights[to];
        
        if (indirectEffort < directEffort) {
            // Use lightest box as intermediary
            effort += (long) boxWeight * lightestWeight;
            effort += (long) lightestWeight * weights[to];
        } else {
            // Direct swap
            effort += directEffort;
        }
        
        // Perform the actual swap
        int temp = weights[from];
        weights[from] = weights[to];
        weights[to] = temp;
        
        return effort;
    }
}