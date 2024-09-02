package t6_recursion.faq_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoringProblem {
    boolean graphColoring(int[][] edges, int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int[] colorsFilled = new int[n];
        Arrays.fill(colorsFilled, 0);
        return canBeFilled(0, m, colorsFilled, adj);
    }

    boolean isPossible(int u, int color, int[] colorsFilled, List<List<Integer>> adj) {
        List<Integer> conn = adj.get(u);
        for (int v : conn) {
            if (colorsFilled[v] == color)
                return false;
        }
        return true;
    }

    boolean canBeFilled(int v, int m, int[] colorsFilled, List<List<Integer>> adj) {
        if (v == adj.size())
            return true;
        for (int color = 1; color <= m; color++) {
            if (isPossible(v, color, colorsFilled, adj)) {
                colorsFilled[v] = color;
                if (canBeFilled(v + 1, m, colorsFilled, adj))
                    return true;
                colorsFilled[v] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 2}};
//        int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
        int n = 4, m = 3;
//        int n = 3, m = 2;

        boolean[][] graph = {{false, true, true, true}, {true, false, true, false},
                {true, true, false, true}, {true, false, true, false}};
//        boolean[][] graph = {{false, true, true}, {true, false, true}, {true, true, false}};

        MColoringProblem obj = new MColoringProblem();
        System.out.println(obj.graphColoring(edges, m, n));

        //GFG problem
        System.out.println(obj.graphColoring(graph, m, n));
    }

    public boolean graphColoring(boolean graph[][], int m, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]) {
                    adj.get(i).add(j);
                }
            }
        }
        int[] colorsFilled = new int[n];
        Arrays.fill(colorsFilled, 0);
        return canBeFilled(0, m, colorsFilled, adj);
    }
}
