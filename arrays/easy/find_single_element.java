package arrays;
import java.util.HashMap;
public class find_single_element {
    public static int brute_force(int[] a) {
        int n = a.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (int i =0;i<n;i++){
            if(map.get(a[i])==1){
                return a[i];
            }
        }
        return -1;
    }
    public static int xor(int[]a){
        int xor1=0;
        for(int i =0;i<a.length;i++){
            xor1^=a[i];
        }
        return xor1;
    }
    public static void main(String[] args) {
int a[] = {1, 2, 3, 4, 5, 1, 2, 3, 4};
// System.out.println(brute_force(a));
System.out.println(xor(a));
    }
}
