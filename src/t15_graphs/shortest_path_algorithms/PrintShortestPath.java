package t15_graphs.shortest_path_algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class PrintShortestPath {
    static class Node {
        int dist;
        int u;
        public Node(int dist, int u) {
            this.dist = dist;
            this.u = u;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        List<List<Node>> adj = new ArrayList<>();
        int[] parent = new int[n + 1];
        int[] minDist = new int[n + 1];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Node(edge[2], edge[1]));
            adj.get(edge[1]).add(new Node(edge[2], edge[0]));
        }

        q.add(new Node(0, 1));
        minDist[1] = 0;
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.u == n)
                break;
            List<Node> conn = adj.get(top.u);
            for (Node ele : conn) {
                int ad = ele.u;
                int wt = ele.dist;
                if (top.dist + wt < minDist[ad]) {
                    minDist[ad] = top.dist + wt;
                    parent[ad] = top.u;
                    q.add(new Node(minDist[ad], ad));
                }
            }
        }
        if (parent[n] == -1) {
            return List.of(-1);
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(0, n);
        int ind = n;
        while (parent[ind] != -1) {
            ans.add(0, parent[ind]);
            ind = parent[ind];
        }
        ans.add(0, minDist[n]);
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};
        int n = 5, m = 6;
        System.out.println(shortestPath(n, m, edges));
    }
}
