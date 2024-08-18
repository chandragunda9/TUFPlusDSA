package t15_graphs.shortest_path_algorithms;

import java.util.*;

public class DijkstrasAlgorithm {
    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));

        Arrays.fill(minDist, (int) 1e9);
        q.add(new Node(S, 0));
        minDist[S] = 0;
        while (!q.isEmpty()) {
            Node top = q.poll();
            int u = top.node;
            int dist = top.dist;
            ArrayList<ArrayList<Integer>> conn = adj.get(top.node);
            for (ArrayList<Integer> it : conn) {
                int v = it.get(0);
                int edgeWt = it.get(1);
                if (dist + edgeWt < minDist[v]) {
                    minDist[v] = dist + edgeWt;
                    q.add(new Node(v, minDist[v]));
                }
            }
        }
        return minDist;
    }

}
