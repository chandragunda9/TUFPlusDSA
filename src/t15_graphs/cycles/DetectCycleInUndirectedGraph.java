package t15_graphs.cycles;

import java.util.List;

public class DetectCycleInUndirectedGraph {
    public boolean isCycle(int V, List<Integer>[] adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis, adj))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(int v, int p, boolean[] vis, List<Integer>[] adj) {
        vis[v] = true;
        List<Integer> conn = adj[v];
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, v, vis, adj))
                    return true;
            } else if (ele != p) {
                return true;
            }
        }
        return false;
    }
}
