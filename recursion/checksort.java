public class checksort {
    public static boolean check(int arr[],int i){
       if (i==arr.length-1){
       return true;}

        if(arr[i]>=arr[i+1])
        return false;
        return check(arr, i+1);
        
    }
    public static void main(String[] args) {
        int arr[]={1,2,5,6,7};
       boolean ans= check(arr, 0);
       System.out.println(ans);
    }
}
