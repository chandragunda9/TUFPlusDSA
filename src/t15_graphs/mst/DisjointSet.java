package t15_graphs.mst;

public class DisjointSet {
    int[] parent;
    int[] ranks;
    int[] sizes;

    public DisjointSet(int n) {
        parent = new int[n + 1];
        ranks = new int[n + 1];
        sizes = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            ranks[i] = 0;
            sizes[i] = 1;
        }
    }

    public int findParent(int node) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node]);
    }

    public void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV)
            return;
        if (sizes[rootV] > sizes[rootU]) {
            parent[rootU] = rootV;
            sizes[rootV] += sizes[rootU];
        } else {
            parent[rootV] = rootU;
            sizes[rootU] += sizes[rootV];
        }
    }

    public boolean find(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        return rootU == rootV;
    }

    public void unionByRank(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);
        if (rootU == rootV)
            return;
        if (ranks[rootV] > ranks[rootU]) {
            parent[rootU] = rootV;
        } else if (ranks[rootU] > ranks[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            ranks[rootU] += 1;
        }
    }
}
