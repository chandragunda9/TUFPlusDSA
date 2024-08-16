package t15_graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
        boolean[] vis = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                count++;
            }
        }
        return count;
    }

    void dfs(int v, boolean[] vis, List<List<Integer>> adj) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj);
            }
        }
    }
}
