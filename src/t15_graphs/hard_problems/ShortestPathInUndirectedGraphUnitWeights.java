package t15_graphs.hard_problems;

import java.util.*;

public class ShortestPathInUndirectedGraphUnitWeights {
    public static void main(String[] args) {
        int[][] edges = {{1, 0}, {2, 1}, {0, 3}, {3, 7}, {3, 4}, {7, 4}, {7, 6}, {4, 5}, {4, 6}, {6, 5}};
        int n = 8, m = 10;
        System.out.println(Arrays.toString(shortestPath(edges, n, m)));
    }

    public static int[] shortestPath(int[][] edges, int N, int M) {
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        int[] minDist = new int[N];

        Arrays.fill(minDist, Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        minDist[0] = 0;
        q.add(0);
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                if (minDist[rem] + 1 < minDist[ele]) {
                    minDist[ele] = minDist[rem] + 1;
                    q.add(ele);
                }
            }
        }
        for (int i = 0; i < minDist.length; i++) {
            if (minDist[i] == Integer.MAX_VALUE)
                minDist[i] = -1;
        }
        return minDist;
    }
}
