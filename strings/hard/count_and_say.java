package strings.hard;

public class count_and_say {
     public String countAndSay(int n) {
         String result = "1";
    for (int i = 1; i < n; i++) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int j = 1; j < result.length(); j++) {
            if (result.charAt(j) == result.charAt(j - 1)) {
                count++;
            } else {
                sb.append(count).append(result.charAt(j - 1));
                count = 1;
            }
        }
        sb.append(count).append(result.charAt(result.length() - 1));
        result = sb.toString();
    }
    return result;
    }
    public static void main(String[] args) {
        count_and_say c = new count_and_say();
        int n = 4; // Example input
        String result = c.countAndSay(n);
        System.out.println("The " + n + "th term in the count-and-say sequence is: " + result);

    }
}
