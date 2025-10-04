import java.util.*;
public class fruit_basket {
    // Function to find the maximum number of fruits we can collect
    // with at most two types of fruits in the baskets.
    public int totalFruit(int[] fruits) {
        int maxLen = 0; // To keep track of the maximum length found
        int left = 0; // Left pointer of the sliding window
        int right = 0; // Right pointer of the sliding window
        Map<Integer, Integer> countMap = new HashMap<>(); // Map to count occurrences of each fruit type
        while(right<fruits.length){
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1); // Add the current fruit to the map
            if(countMap.size()>2){
                countMap.put(fruits[left], countMap.get(fruits[left]) - 1); // Remove one occurrence of the leftmost fruit
                if(countMap.get(fruits[left])==0){
                    countMap.remove(fruits[left]); // Remove the fruit type from the map if its count is zero
                }
                left++; // Move the left pointer to the right
            }
            if(countMap.size()<=2){
                maxLen = Math.max(maxLen, right - left + 1); // Update the maximum length if the window is valid
            }
            right++; // Move the right pointer to the right
        }
        return maxLen; // Return the maximum length found
    }
    public static void main(String[] args) {
        fruit_basket obj = new fruit_basket();
        int[] fruits = {1,2,1,2,3};
        System.out.println("The maximum number of fruits that can be collected is " + obj.totalFruit(fruits));
    }
}
