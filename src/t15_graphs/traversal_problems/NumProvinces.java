package t15_graphs.traversal_problems;

public class NumProvinces {
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

    public int numProvinces(int[][] adj) {
        DisjointSet dis = new DisjointSet(adj.length);
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                if (i != j && adj[i][j] == 1) {
                    dis.unionBySize(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < adj.length; i++) {
            if (dis.findParent(i) == i) {
                count++;
            }
        }
        return count;
    }

    public int method1(int[][] adj) {
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

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}};
        NumProvinces obj = new NumProvinces();
        System.out.println(obj.numProvinces(mat));
    }
}
