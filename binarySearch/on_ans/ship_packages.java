package binarySearch.on_ans;
public class ship_packages {
     private int func(int[] weights,int capacity){
        int days=1,load=0;
        for(int i =0;i<weights.length;i++){
            if(load+weights[i] > capacity){
                days++;
                load =weights[i];
            }
            else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int i =0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high += weights[i];
        }
        int noOfDays=0;
        while(low<=high){
        int mid = (low+high)/2;
            noOfDays=func(weights,mid);
            if(noOfDays <=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        ship_packages obj = new ship_packages();
        int result = obj.shipWithinDays(weights, days);
        System.out.println("The least weight capacity of the ship is: " + result);
    }
}
