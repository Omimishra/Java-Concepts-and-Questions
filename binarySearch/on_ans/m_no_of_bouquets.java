package binarySearch.on_ans;

public class m_no_of_bouquets {
    private boolean possible(int arr[], int day, int m, int k) {
        int n = arr.length;
        int c = 0;
        int noOfB = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= day)
                c++;
            else {
                noOfB += (c / k);
                c = 0;
            }
        }
        noOfB += (c / k);
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) k * m;
        int n = bloomDay.length;
        if (val > n)
            return -1;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, bloomDay[i]);
            maxi = Math.max(maxi, bloomDay[i]);
        }
        int low = mini;
        int high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k))
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        m_no_of_bouquets obj = new m_no_of_bouquets();
        int result = obj.minDays(bloomDay, m, k);
        System.out.println("The minimum number of days is: " + result);
    }
}
