package hard;

import java.util.ArrayList;
import java.util.List;
// Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with the same color.

public class m_coloring {
    public static boolean graphColoring(List < Integer > [] G, int[] color, int i, int C) {
        int n = G.length;// Number of nodes in the graph
        if(solve(i,G,color,n,C))
            return true;
        return false;
    }
    // // Helper function to check if it's safe to color 'node' with color 'c'
    private static boolean isSafe(int node,List<Integer> []G, int[] color, int n, int c) {
         // Check all adjacent nodes
        for(int i = 0; i < G[node].size(); i++) {
            // If any adjacent node has the same color, it's not safe
            if(color[G[node].get(i)] == c) {
                return false;
            }
        }
        return true;
    }
    private static boolean solve(int node,List<Integer> []G, int[] color, int n, int m) {
        if(node == n) {
            return true;
        }
        // Try all colors from 1 to m for the current node
        for(int i = 1; i <= m; i++) {
            // Check if it's safe to color this node with color i
            if(isSafe(node, G, color,n, i)) {
                color[node] = i;//assign color i to the node
                if(solve(node + 1, G, color, n, m)) {
                    return true;// If coloring is possible, return true
                }
                color[node] = 0;// Backtrack: remove color assignment
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int N = 4, M = 3;
        @SuppressWarnings("unchecked")
        List < Integer > [] G = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            G[i] = new ArrayList < > ();
        }
        G[0].add(1);
        G[1].add(0);
        G[1].add(2);
        G[2].add(1);
        G[2].add(3);
        G[3].add(2);
        G[3].add(0);
        G[0].add(3);
        G[0].add(2);
        G[2].add(0);
        int[] color = new int[N];
        boolean ans = graphColoring(G, color, 0, M);
        System.out.println(ans);
    }
}
