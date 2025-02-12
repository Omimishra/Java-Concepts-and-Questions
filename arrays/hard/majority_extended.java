package arrays.hard;
import java.util.*;
public class majority_extended {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int c1 = 0;
        int c2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (c1 == 0 && nums[i] != e2) {
                e1 = nums[i];
                c1 = 1;
            } else if (c2 == 0 && nums[i] != e1) {
                e2 = nums[i];
                c2 = 1;
            } else if (nums[i] == e1)
                c1++;
            else if (nums[i] == e2)
                c2++;
            else {
                c1--;
                c2--;
            }
        }
        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == e1)
                c1++;
            if (nums[i] == e2)
                c2++;
        }

        if (c1 > n / 3)
            ans.add(e1);
        if (c2 > n / 3)
            ans.add(e2);
            return ans;
    }
    public static void main(String args[]) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
