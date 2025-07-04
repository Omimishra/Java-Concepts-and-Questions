package recursion.subsequences_pattern;

import java.util.ArrayList;
import java.util.List;

public class binary_string {
    public void generateHelper(String current,int n, List<String> list){
        if(current.length()==n){
            list.add(current);
            return;
        }
        generateHelper(current+"0",n,list);
        if(current.isEmpty() || current.charAt(current.length()-1)!='1'){
            generateHelper(current+"1",n,list);
        }
    }
    public List<String> generateBinaryStrings(int n) {
        List<String> list = new ArrayList<>();
        generateHelper("", n, list);
        return list;
    }
    public static void main(String[] args) {
        binary_string bs = new binary_string();
        List<String> result = bs.generateBinaryStrings(3);
        System.out.println(result); // Output: [000, 001, 010, 011, 100, 101, 110]
    }
}
