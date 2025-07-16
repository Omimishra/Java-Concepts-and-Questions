
public class optimized_all_permutations {
    public void permute(int[] nums, int index) {
        if (index == nums.length) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);//swap the elements
            permute(nums, index + 1);//
            swap(nums, i, index);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        optimized_all_permutations obj = new optimized_all_permutations();
        obj.permute(nums, 0);
    }
}
