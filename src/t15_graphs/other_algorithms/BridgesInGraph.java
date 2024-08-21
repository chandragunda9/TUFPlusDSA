package t15_graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BridgesInGraph {
    int timer = 0;

    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[V];
        int[] disTime = new int[V];
        int[] lowTime = new int[V];
        List<List<Integer>> bridges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : E) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, disTime, lowTime, adj, bridges);
            }
        }
        return bridges;
    }

    void dfs(int u, int p, boolean[] vis, int[] disTime, int[] lowTime, List<List<Integer>> adj,
             List<List<Integer>> bridges) {
        vis[u] = true;
        disTime[u] = lowTime[u] = ++timer;
        List<Integer> conn = adj.get(u);
        for (Integer v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, bridges);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] > disTime[u]) {
                    bridges.add(new ArrayList<>(Arrays.asList(u, v)));
                }
            } else if (v != p) {
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
            }
        }
    }

    public static void main(String[] args) {
        BridgesInGraph obj = new BridgesInGraph();
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {1, 3}};
        List<List<Integer>> li = Arrays.stream(edges).map(a ->
                Arrays.stream(a).boxed().collect(Collectors.toList())).toList();
        int n = 4;
        System.out.println(obj.criticalConnections(n, li));
    }
}
