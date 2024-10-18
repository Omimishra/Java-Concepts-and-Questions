import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class nomoresymbols {

    public static int operations(String i, int op1, int op2) {

        if (i == "add")
            return op1 + op2;

        else if (i == "sub")
            return op1 - op2;

        else if (i == "mul")
            return op1 * op2;

        else if (i == "rem")
            return op1 % op2;

        else if (i == "pow")
            return (int) Math.pow(op1, op2);
        else
            return 0;

    }

    public static int calculate(String input) {
        String[] words = input.split(" ");
        if (words.length == 3) {
            // single operation
            String op = words[0];
            if (!map.containsKey(words[1]) || !map.containsKey(words[2])) {
                return -1; // Invalid words present
            }
            int op1 = map.get(words[1]);
            int op2 = map.get(words[2]);
            return operations(op, op1, op2);
        } else if (words.length == 5) {
            // Two operations
            String operation1 = words[0];
            String operation2 = words[1];
            if (!map.containsKey(words[2]) || !map.containsKey(words[3]) || !map.containsKey(words[4])) {
                return -1; // Invalid words present
            }
            int op1 = map.get(words[2]);
            int op2 = map.get(words[3]);
            int op3 = map.get(words[4]);
            int result1 = operations(operation1, op1, op2);
            return operations(operation2, result1, op3);
        } else if (words.length == 5) {
            // Two operations with different order
            String operation1 = words[0];
            String operand1 = (words[1]);
            String operation2 = words[2];
            String operand2 = (words[3]);
            String operand3 = (words[4]);
            if (!map.containsKey(operand1) || !map.containsKey(operand2) || !map.containsKey(operand3)) {
                return -1; // Invalid words present
            }
            int op1 = map.get(operand1);
            int op2 = map.get(operand2);
            int op3 = map.get(operand3);
            int result1 = operations(operation2, op2, op3);
            return operations(operation1, op1, result1);
        }
        else {
            System.out.println("expression is not complete or invalid");
            return -1;
    }
}
private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression:");
        String input = sc.nextLine();
        int result = calculate(input);

        if (result == -1) {
        System.out.println("expression evaluation stopped invalid words present");
            }
        System.out.println(result);
        sc.close();
        }
    }
