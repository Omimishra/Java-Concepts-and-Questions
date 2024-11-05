import java.util.*;
public class HammingDist {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                String bin = sc.nextLine();
                String[] costInputs = sc.nextLine().split(" ");
                int A = Integer.parseInt(costInputs[0]);
                int B = Integer.parseInt(costInputs[1]);
                results.add(minimizeCost(bin, A, B));
            }
    
            for (int result : results) {
                System.out.println(result);
            }
    
            sc.close();
        }
    
        public static int minimizeCost(String bin, int A, int B) {
            if (!bin.matches("[01]+")) {
                System.out.println("INVALID");
                return -1;
            }
            int count0 = 0;
            int count1 = 0;
            for (char ch : bin.toCharArray()) {
                if (ch == '0') count0++;
                else count1++;
            }
            String rearrangedStr;
            @SuppressWarnings("unused")
            int o;
            if (A < B) {
                rearrangedStr = "1".repeat(count1) + "0".repeat(count0);
                o = (count0 > 0 && count1 > 0) ? A : 0;
            } else {
                rearrangedStr = "0".repeat(count0) + "1".repeat(count1);
                o = (count0 > 0 && count1 > 0) ? B : 0;
            }
            int hammingdist = 0;
            for (int i = 0; i < bin.length(); i++) {
                if (bin.charAt(i) != rearrangedStr.charAt(i)) {
                    hammingdist++;
                }
            }
    
            return hammingdist;
        }
    }
     

