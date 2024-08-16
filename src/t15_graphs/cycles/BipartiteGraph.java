package t15_graphs.cycles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class BipartiteGraph {
    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        List<Integer>[] li = Arrays.stream(arr).map(a -> Arrays.stream(a).boxed().
                collect(Collectors.toList())).toArray(List[]::new);
        System.out.println(isBipartite(4, li));
    }

    public static boolean isBipartite(int V, List<Integer>[] adj) {
        int[] colorsFilled = new int[V];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < V; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfs(i, 0, colorsFilled, adj))
                    return false;
            }
        }
        return true;
    }

    static boolean dfs(int v, int color, int[] colorsFilled, List<Integer>[] adj) {
        colorsFilled[v] = color;
        List<Integer> conn = adj[v];
        for (int ele : conn) {
            if (colorsFilled[ele] != -1) {
                if (!dfs(ele, 1 - color, colorsFilled, adj)) {
                    return false;
                }
            } else if (colorsFilled[ele] == color) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] colorsFilled = new int[V];
        Arrays.fill(colorsFilled, -1);
        for (int i = 0; i < V; i++) {
            if (colorsFilled[i] == -1) {
                if (!dfs1(i, 0, colorsFilled, adj))
                    return false;
            }
        }
        return true;
    }

    static boolean dfs1(int v, int color, int[] colorsFilled, ArrayList<ArrayList<Integer>> adj) {
        colorsFilled[v] = color;
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (colorsFilled[ele] == -1) {
                if (!dfs1(ele, 1 - color, colorsFilled, adj)) {
                    return false;
                }
            } else if (colorsFilled[ele] == color) {
                return false;
            }
        }
        return true;
    }
}
