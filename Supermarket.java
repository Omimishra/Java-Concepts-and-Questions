import java.util.*;

public class Supermarket {
//     In a Super market we will find many variations of the same product. In the same way we can find many types of rice bags which differ in its quantity, price, brand, and type of rice in it. Many variations of same products exist in a super market. Consider rice for example. We get it in varying quantities (q) and at different prices (p).
// Thus rice bag is unique combination of q,p. Customers want to buy the rice bags of their own choices. Each bag has two attributes price and the quantity of rice. The customers have some conditions for buying the rice bags, they have a specific price and quantity that have to be compared with the rice bags before buying them. If the price of rice bag is less than or equal to the customer’s preference and if the quantity is more than given preference, then he/she will buy it. There is only one bag of each type and each customer can buy at most one bag.
// Given n, m representing the number of customers and rice bags respectively, along with the variations of rice bags available in the market and the preferences of customers, find the maximum number of bags that can be sold by the end of the day.

// Input Format
// The first line contains two space separated integers n and m denoting the number of customers and number of rice bags respectively.
// Next n lines consist of two space separated integers a and b denoting customer’s preferences viz. customer’s quantity and cost preferences, respectively.
// Lastly, the next m lines consist of two space separated integers q and p denoting the bags quantity and cost, respectively.
//  Output Format
// Print the maximum number of rice bags that can be sold.

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // number of customers
    int m = sc.nextInt(); // number of rice bags
    ArrayList<int[]> customers = new ArrayList<>();
    ArrayList<int[]> rice = new ArrayList<>();
    for(int i=0;i<n;i++){
        int a = sc.nextInt(); // customer's quantity preference
        int b = sc.nextInt(); // customer's cost preference
        customers.add(new int[]{b, a}); // storing as {cost, quantity}
        }
        for(int i=0;i<m;i++){
            int q = sc.nextInt(); // bag quantity 
            int p = sc.nextInt(); // bag cost 
            rice.add(new int[]{p, q}); // storing as {cost, quantity}
            }
            // Sort customers and rice bags by cost
        customers.sort(Comparator.comparingInt(a -> a[0]));
        rice.sort(Comparator.comparingInt(a -> a[0]));

        int[] good = new int[m]; // array to track which rice bags have been used
        int ans = 0; // answer to store the total number of satisfied customers

        for (int i = 0; i < n; i++) {// for n customers
            int quan = -1;
            int index = -1;
            for (int j = 0; j < m; j++) { // for each rice bag
                if (good[j] == 0) { // check if rice bag has not been used
                    if (rice.get(j)[0] > customers.get(i)[0]) break; // rice cost must be <= customer's cost
                    if (rice.get(j)[1] > customers.get(i)[1]) { // rice quantity must be > customer's quantity
                        if (quan == -1) {
                            quan = rice.get(j)[1];
                            index = j;
                        } else {
                            if (quan > rice.get(j)[1]) {
                                index = j;
                                quan = rice.get(j)[1];
                            }
                        }
                    }
                }
            }
            if (index != -1) { // if a suitable rice bag is found
                good[index] = 1; // mark it as used
                ans++; // increment satisfied customers count
            }
        }
        
        System.out.println(ans); // print the total number of satisfied customers
        sc.close();
    }
}
