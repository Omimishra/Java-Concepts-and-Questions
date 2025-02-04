package arrays.hard;

import java.util.*;

public class Sum_3 {
    public static ArrayList<ArrayList<Integer>> triplet(int n, int[] arr) {
        Set<ArrayList<Integer>> st = new HashSet<>();

        // Time complexity: O(n^3)
        // check all possible triplets:
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        // better approach:
        // for (int i = 0; i < n; i++) {
        // Set<Integer> hashset = new HashSet<>();
        // for (int j = i + 1; j < n; j++) {
        // //Calculate the 3rd element:
        // int third = -(arr[i] + arr[j]);

        // //Find the element in the set:
        // if (hashset.contains(third)) {
        // List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
        // temp.sort(null);
        // st.add(temp);
        // }
        // hashset.add(arr[j]);
        // }
        // }

        // store the set elements in the answer:
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(st);
        return ans;
    }

    public static ArrayList<ArrayList<Integer>> optimal(int n, int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i != 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j + 1])
                        j++;
                    while (j < k && arr[k] == arr[k - 1])
                        k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = optimal(n, arr);
        for (ArrayList<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
