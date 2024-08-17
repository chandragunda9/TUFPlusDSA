package t15_graphs.hard_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    static class Node {
        int val;
        int weight;

        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int N, int M, int[][] edges) {
        Stack<Integer> st = new Stack<>();
        List<List<Node>> adj = new ArrayList<>();
        boolean[] vis = new boolean[N];
        int[] dist = new int[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            adj.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
        }

        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj, st);
            }
        }
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            List<Node> conn = adj.get(node);
            for (Node ele : conn) {
                if (dist[node] != Integer.MAX_VALUE && dist[node] + ele.weight < dist[ele.val]) {
                    dist[ele.val] = dist[node] + ele.weight;
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    void dfs(int v, boolean[] vis, List<List<Node>> adj, Stack<Integer> st) {
        vis[v] = true;
        List<Node> conn = adj.get(v);
        for (Node ele : conn) {
            if (!vis[ele.val]) {
                dfs(ele.val, vis, adj, st);
            }
        }
        st.push(v);
    }
}
