import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrabhuExpressionEvaluator {
    
    private static final Map<String, Integer> numberWords = new HashMap<>();
    private static final Map<String, String> operations = new HashMap<>();

    static {
        numberWords.put("zero", 0);
        numberWords.put("one", 1);
        numberWords.put("two", 2);
        numberWords.put("three", 3);
        numberWords.put("four", 4);
        numberWords.put("five", 5);
        numberWords.put("six", 6);
        numberWords.put("seven", 7);
        numberWords.put("eight", 8);
        numberWords.put("nine", 9);
        
        operations.put("add", "+");
        operations.put("sub", "-");
        operations.put("mul", "*");
        operations.put("rem", "%");
        operations.put("pow", "");
    }

    private static Integer wordToNumber(String word) {
        if (word == null || word.isEmpty()) {
            return null;
        }
        if (word.charAt(0) == 'c') {
            StringBuilder numStr = new StringBuilder();
            for (int i = 1; i < word.length(); i++) {
                String part = word.substring(i, i + 1);
                Integer digit = numberWords.get(part);
                if (digit == null) {
                    return null;
                }
                numStr.append(digit);
            }
            return Integer.parseInt(numStr.toString());
        } else {
            return numberWords.get(word);
        }
    }

    public static String evaluateExpression(String expression) {
        String[] words = expression.split(" ");
        
        for (String word : words) {
            if (!numberWords.containsKey(word) && !operations.containsKey(word) && !word.startsWith("c")) {
                return "expression evaluation stopped invalid words present";
            }
        }

        if (words.length < 3) {
            return "expression is not complete or invalid";
        }

        String op1 = words[0];
        if (!operations.containsKey(op1)) {
            return "expression is not complete or invalid";
        }

        Integer result;
        
        if (words.length == 3) {
            // Single operation case
            Integer operand1 = wordToNumber(words[1]);
            Integer operand2 = wordToNumber(words[2]);

            if (operand1 == null || operand2 == null) {
                return "expression evaluation stopped invalid words present";
            }

            result = eval(operand1, op1, operand2);
        } else {
            // Two function case
            String op2 = words[1];
            if (!operations.containsKey(op2)) {
                return "expression is not complete or invalid";
            }

            Integer operand1 = wordToNumber(words[2]);
            Integer operand2 = wordToNumber(words[3]);

            if (operand1 == null || operand2 == null) {
                return "expression evaluation stopped invalid words present";
            }

            Integer intermediateResult = eval(operand1, op2, operand2);
            for (int i = 4; i < words.length; i++) {
                String word = words[i];
                if (!operations.containsKey(op1)) {
                    return "expression is not complete or invalid";
                }
                Integer operand = wordToNumber(word);
                if (operand == null) {
                    return "expression evaluation stopped invalid words present";
                }
                intermediateResult = eval(intermediateResult, op1, operand);
            }

            result = intermediateResult;
        }

        return result != null ? result.toString() : "expression is not complete or invalid";
    }

    private static Integer eval(Integer operand1, String operator, Integer operand2) {
        switch (operator) {
            case "add":
                return operand1 + operand2;
            case "sub":
                return operand1 - operand2;
            case "mul":
                return operand1 * operand2;
            case "rem":
                return operand1 % operand2;
            case "pow":
                return (int) Math.pow(operand1, operand2);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the expression:");
        String expression = scanner.nextLine();
        System.out.println(evaluateExpression(expression));
    }
}