package strings.medium;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class sort_char_by_freq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
       //build a max heap
       PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
       pq.addAll(frequencyMap.entrySet());

       StringBuilder result = new StringBuilder();
       while(!pq.isEmpty()){
        Map.Entry<Character,Integer> entry = pq.poll();
        for(int i =0;i<entry.getValue();i++){
            result.append(entry.getKey());
        }
        }
        return result.toString();


    }
    public static void main(String[] args) {
        sort_char_by_freq obj = new sort_char_by_freq();
        String s = "tree";
        String result = obj.frequencySort(s);
        System.out.println(result); // Output: "eetr" or "eert" depending on the implementation
    }
}

