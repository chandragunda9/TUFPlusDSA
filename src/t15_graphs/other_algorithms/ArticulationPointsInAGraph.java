package t15_graphs.other_algorithms;

import java.util.*;
import java.util.stream.Collectors;

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

    public ArrayList<Integer> method2(int n,
                                      ArrayList<ArrayList<Integer>> adj) {
        Set<List<Integer>> allEdges = new HashSet<>();
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> conn = adj.get(i);
            for (int v : conn) {
                List<Integer> edge = new ArrayList<>(Arrays.asList(i, v));
                Collections.sort(edge);
                allEdges.add(edge);
            }
        }

        DisjointSet origDisjointSet = new DisjointSet(n);
        for (List<Integer> edge : allEdges) {
            origDisjointSet.unionBySize(edge.get(0), edge.get(1));
        }
        int origNoc = 0;
        for (int i = 0; i < n; i++) {
            if (origDisjointSet.findParent(i) == i)
                origNoc++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            DisjointSet dis = new DisjointSet(n);
            for (List<Integer> edge : allEdges) {
                if (edge.get(0) == i || edge.get(1) == i)
                    continue;
                dis.unionBySize(edge.get(0), edge.get(1));
            }
            int noc = 0;
            for (int j = 0; j < n; j++) {
                if (j == i)
                    continue;
                if (dis.findParent(j) == j)
                    noc++;
            }
            if (noc > origNoc)
                ans.add(i);
        }
        return ans.isEmpty() ? new ArrayList<>(List.of(-1)) : ans;
        //Got time limit exceeded with the above approach in GFG
    }

    public static void main(String[] args) {
        int[][] ad = {{1, 2, 3}, {0}, {0, 3, 4, 5}, {2, 0}, {2, 6}, {2, 6}, {4, 5}};
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = Arrays.stream(ad).map(a -> Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        ArticulationPointsInAGraph obj = new ArticulationPointsInAGraph();
        System.out.println(obj.method2(n, adj));
    }
}
