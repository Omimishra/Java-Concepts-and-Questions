package strings.hard;

public class index_of_first_occurrence {
    public int strStr(String haystack, String needle) {
        for(int i =0,j = needle.length();j<=haystack.length();i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i ;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        index_of_first_occurrence i = new index_of_first_occurrence();
        String haystack = "hello"; // Example input
        String needle = "ll"; // Example input 
        int result = i.strStr(haystack, needle);
        System.out.println("The index of the first occurrence of needle in haystack is: " + result);
    }
}
