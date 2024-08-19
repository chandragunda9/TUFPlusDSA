package t15_graphs.shortest_path_algorithms;

import java.util.*;

public class NumberOfWaysToReachDestination {
    static class Pair {
        int time;
        int node;

        public Pair(int time, int node) {
            this.time = time;
            this.node = node;
        }
    }

    public int countPaths(int n, List<List<Integer>> roads) {
        int mod = (int) (1e9 + 7);
        List<List<Pair>> adj = new ArrayList<>();
        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        int[] minTime = new int[n];
        int[] ways = new int[n];

        Arrays.fill(minTime, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> road : roads) {
            adj.get(road.get(0)).add(new Pair(road.get(2), road.get(1)));
            adj.get(road.get(1)).add(new Pair(road.get(2), road.get(0)));
        }
        minTime[0] = 0;
        ways[0] = 1;
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair top = q.poll();
            List<Pair> conn = adj.get(top.node);
            for (Pair it : conn) {
                int v = it.node;
                int time = it.time;
                if (top.time + time < minTime[v]) {
                    minTime[v] = top.time + time;
                    q.add(new Pair(minTime[v], v));
                    ways[v] = ways[top.node];
                } else if (top.time + time == minTime[v]) {
                    ways[v] = (ways[v] + ways[top.node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}
