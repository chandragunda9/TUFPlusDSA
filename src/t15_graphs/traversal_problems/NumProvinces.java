package t15_graphs.traversal_problems;

public class NumProvinces {
    public int numProvinces(int[][] adj) {
        int V = adj.length;
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

    void dfs(int v, boolean[] vis, int[][] adj) {
        vis[v] = true;
        int[] conn = adj[v];
        for (int adjV = 0; adjV < conn.length; adjV++) {
            if (adjV != v && conn[adjV] == 1 && !vis[adjV]) {
                dfs(adjV, vis, adj);
            }
        }
    }
}
