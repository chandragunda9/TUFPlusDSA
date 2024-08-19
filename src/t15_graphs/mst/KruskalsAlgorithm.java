package t15_graphs.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {
    static class Edge {
        int u;
        int v;
        int weight;

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        DisjointSet dis = new DisjointSet(V);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < adj.size(); i++) {
            List<List<Integer>> conn = adj.get(i);
            for (List<Integer> ele : conn) {
                Edge e = new Edge(i, ele.get(0), ele.get(1));
                edges.add(e);
            }
        }
        edges.sort(Comparator.comparingInt(a -> a.weight));
        int mstWeight = 0;
        for (Edge e : edges) {
            if (dis.findParent(e.u) != dis.findParent(e.v)) {
                mstWeight += e.weight;
                dis.unionBySize(e.u, e.v);
            }
        }
        return mstWeight;
    }
}
