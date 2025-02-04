package hashing;

import java.util.*;

public class majority_element {
    public static int major(int nums[]) {
        // O(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return 0;
    }

    public static int majoptimal(int nums[]) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < nums.length;) {
            if (count == 0) {
                ans = nums[i];
            }
            if (ans == nums[i])
                count++;
            else
                count--;
            return ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 2, 1, 2, 1, 2, 1 };
        int ans = majoptimal(nums);
        System.out.println(ans);
    }
}
