package t15_graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    static class DisjointSet {
        int[] parent;
        int[] sizes;

        DisjointSet(int n) {
            parent = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        int findParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int rootU = findParent(u);
            int rootV = findParent(v);
            if (rootU == rootV)
                return;
            if (sizes[rootU] < sizes[rootV]) {
                parent[rootU] = rootV;
                sizes[rootV] += sizes[rootU];
            } else {
                parent[rootV] = rootU;
                sizes[rootU] += sizes[rootV];
            }
        }
    }

    public int findNumberOfComponent(int E, int V, List<List<Integer>> edges) {
        int count = 0;
        DisjointSet dis = new DisjointSet(V);
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            dis.unionBySize(u, v);
        }
        for (int i = 0; i < V; i++) {
            if (dis.findParent(i) == i)
                count++;
        }
        return count;
    }

    public int method1(int E, int V, List<List<Integer>> edges) {
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
