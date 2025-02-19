package arrays;

public class container_with_most_water {
    public static int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int width = j - i;
            int ht = Math.min(height[i], height[j]);
            int area = width * ht;
            max = Math.max(max,area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
    
}
