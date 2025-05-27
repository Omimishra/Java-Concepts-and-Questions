package strings;
public class largestoddnumber {
    public String largestOddNumber(String num) {
        int n = num.length();
        StringBuilder result = new StringBuilder();

        // Traverse the string from the end to the beginning
        for (int i = n - 1; i >= 0; i--) {
            char digit = num.charAt(i);
            // Check if the digit is odd
            if ((digit - '0') % 2 != 0) {
                // Append all digits up to and including this odd digit
                result.append(num.substring(0, i + 1));
                break;
            }
        }

        // If no odd digit was found, return an empty string
        return result.length() > 0 ? result.toString() : "";
    }


    public static void main(String[] args) {
        largestoddnumber obj = new largestoddnumber();
        String num = "123456789";
        String result = obj.largestOddNumber(num);
        System.out.println(result); // Output: 97531
    }
}   

