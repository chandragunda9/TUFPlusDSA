package t15_graphs.shortest_path_algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmannFordAlgorithm {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
        int mod = (int) 1e9;
        int[] dist = new int[V];
        Arrays.fill(dist, mod);
        dist[S] = 0;
        for (int i = 1; i <= V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dist[u] != mod && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (dist[u] != mod && dist[u] + wt < dist[v]) {
                return new int[]{-1};
            }
        }
        return dist;
    }
}
