package strings.medium;

public class string_to_int {
    public int myAtoi(String s) {
        s = s.trim(); // Remove leading and trailing whitespace
        if (s.isEmpty())
            return 0; // Return 0 if the string is empty

        int sign = 1; // Default sign is positive
        int i = 0; // Start index for parsing
        long result = 0; // Use long to handle overflow

        // Check for optional sign
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Parse digits
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            result = result * 10 + (ch - '0'); // Convert char to digit and build the result
            // Check for overflow
            if (result * sign > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (result * sign < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) (result * sign); // Return the final result with the correct sign
    }
}
