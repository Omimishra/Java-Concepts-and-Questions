import java.util.*;
public class TheStringPuzzle {
    public static int calculateStringValue(int n, List<String[]> edges, String[] inputWords) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for (String[] edge : edges) {
            String from = edge[0];
            String to = edge[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            inDegree.putIfAbsent(from, 0);
        }
        Map<String, Integer> levels = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.add(node);
                levels.put(node, 1); 
            }
        }
        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentLevel = levels.get(current);
            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                        levels.put(neighbor, currentLevel + 1);
                    }
                }
            }
        }
        int totalValue = 0;
        for (String word : inputWords) {
            totalValue += levels.getOrDefault(word, -1); 
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        List<String[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            edges.add(line.split(" "));
        }
       
        String inputString = sc.nextLine();
        String[] inputWords = inputString.split(" ");
        System.out.println(calculateStringValue(n, edges, inputWords));
        sc.close();
    }
}


