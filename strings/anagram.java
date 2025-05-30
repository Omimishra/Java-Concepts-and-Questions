package strings;
public class anagram {
    public static boolean checkAnagrams(String s, String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = checkAnagrams(s, t);
        System.out.println(result); // Output: true

        String s2 = "rat";
        String t2 = "car";
        boolean result2 = checkAnagrams(s2, t2);
        System.out.println(result2); // Output: false
    }
    
}
