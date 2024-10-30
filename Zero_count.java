import java.util.*;
// You are given a binary string B of length L which contains K ones and remaining zeros. You are required to place the K ones in the binary string in such a way that the longest consecutive zeros have the least length possible. Once such a binary string is constructed, you are required to print the length of the contiguous block of zeros, which has the largest length.

// Input Format
// Single line consisting of two space separated integers denoting L and K

// Output Format
// Print a single integer denoting the length of the longest consecutive zeros as per the problem.
public class Zero_count {
    public static int longestConsecutiveZerosLength(int L, int K) {
        if (K == 0) {
            // If there are no '1's in the string, return the length of the string itself.
            return L;
        } else if (K == L) {
            // If all positions are filled with '1's, return 0 as there are no '0's.
            return 0;
        } else {
            // Calculate the minimum length of consecutive zeros using the formula.
            int minZerosLength = (L - K) / (K + 1);
            return minZerosLength;
        }
    }

    public static void main(String[] args) {
        // Take input using Scanner
        Scanner sc = new Scanner(System.in);
        
        int L = sc.nextInt(); // length of the binary string
        int K = sc.nextInt(); // number of '1's in the string

        // Call the function and print the result
        int result = longestConsecutiveZerosLength(L, K);
        System.out.println(result);
        
        sc.close(); // Close the scanner
    }
}


