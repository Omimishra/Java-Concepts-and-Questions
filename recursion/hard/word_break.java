package hard;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// s = "leetcode", wordDict = ["leet","code"]
// Output: true

public class word_break {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for fast lookup
        Set<String> dict = new HashSet<>(wordDict); // O(1) lookup

        int n = s.length();
        // dp[i] is true if s[0...i-1] can be segmented using words from dict
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string can always be segmented

        // Check every prefix s[0...i-1]
        for (int i = 1; i <= n; i++) {
            // Try every possible split position j for s[0...i-1]
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] can be segmented and s[j...i-1] is in dict
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true; // s[0...i-1] can be segmented
                    break; // No need to check further splits for this i
                }
            }
        }
        // Return whether the entire string can be segmented
        return dp[n];
    }
}