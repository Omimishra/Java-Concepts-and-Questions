package arrays;
import java.util.*;
public class merge_overlapping_intervals {
    public static List<List<Integer>> merge(int arr[][]){
        List<List<Integer>> res = new ArrayList<>();
        if(arr.length == 0 || arr == null){
            return res;
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));
        int start = arr[0][0]; // taking the first element of first interval 
        int end = arr[0][1]; // taking the second element of first interval
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] <= end){ // if the start of next interval is less than or equal to end of previous interval
                end = Math.max(end, arr[i][1]);// then update the end of previous interval
            }else{
                res.add(Arrays.asList(start, end));// else add the previous interval to the result
                start = arr[i][0];// update the start of interval to the start of next interval
                end = arr[i][1];// update the end of interval to the end of next interval
            }
        }
        res.add(Arrays.asList(start, end));// add the last interval to the result
        return res;
    }
    public static int[][] merge1(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= prev[1]){
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }else{
                res.add(prev);
                prev = intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
        List<List<Integer>> res = merge(arr);
        int[][] res1 = merge1(arr);
        for(int[] i : res1){
            System.out.println(Arrays.toString(i));
        }
        for(List<Integer> i : res){
            System.out.println(i);
        }
    }
}
