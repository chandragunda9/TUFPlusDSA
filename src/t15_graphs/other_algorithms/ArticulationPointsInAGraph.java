package t15_graphs.other_algorithms;

import java.util.ArrayList;
import java.util.List;

public class ArticulationPointsInAGraph {
    int timer = 0;

    public ArrayList<Integer> articulationPoints(int n,
                                                 ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[n];
        int[] disTime = new int[n];
        int[] lowTime = new int[n];
        boolean[] isArtPoint = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, disTime, lowTime, adj, isArtPoint);
            }
        }
        for (int i = 0; i < n; i++) {
            if (isArtPoint[i])
                ans.add(i);
        }
        return ans.isEmpty() ? new ArrayList<>(List.of(-1)) : ans;
    }

    void dfs(int u, int parent, boolean[] vis, int[] disTime, int[] lowTime,
             ArrayList<ArrayList<Integer>> adj, boolean[] isArticulationPoint) {
        vis[u] = true;
        disTime[u] = lowTime[u] = ++timer;
        ArrayList<Integer> conn = adj.get(u);
        int child = 0;
        for (Integer v : conn) {
            if (!vis[v]) {
                dfs(v, u, vis, disTime, lowTime, adj, isArticulationPoint);
                lowTime[u] = Math.min(lowTime[u], lowTime[v]);
                if (lowTime[v] >= disTime[u] && parent != -1) {
                    isArticulationPoint[u] = true;
                }
                child++;
            } else if (v != parent) {
                lowTime[u] = Math.min(lowTime[u], disTime[v]);
            }
        }
        if (parent == -1 && child > 1) {
            isArticulationPoint[u] = true;
        }
    }
}
