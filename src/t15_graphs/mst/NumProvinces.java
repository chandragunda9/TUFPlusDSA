package t15_graphs.mst;

public class NumProvinces {
    public int numProvinces(int[][] adj, int V) {
        DisjointSet dis = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    continue;
                if (adj[i][j] == 1) {
                    dis.unionBySize(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (dis.findParent(i) == i)
                count++;
        }
        return count;
    }
}
