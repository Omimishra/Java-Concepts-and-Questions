package strings.medium;
public class count_substrings {
    //Given string s consisting only a,b,c. return the number of substrings containing at least one occurrence of all these characters a, b, and c.
    public static int countSubstring(String s) {
        // code here
        int n = s.length();
        int max = 0;
        int index = 0;
        int lastIndex[] = new int[3];
        for(int i =0;i<3;i++){
            lastIndex[i] = -1;
            
        }
        while(index<n){
            lastIndex[s.charAt(index) - 'a'] = index;
            int minIndex = Math.min(lastIndex[0],Math.min(lastIndex[1],lastIndex[2]));
            if(minIndex!=-1){
                max+= minIndex+1;
            }
            index++;
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abcabc";
        int result = countSubstring(s);
        System.out.println("Number of substrings containing at least one occurrence of a, b, and c: " + result);
    }
    
}
