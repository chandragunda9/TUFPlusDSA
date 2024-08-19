package t15_graphs.shortest_path_algorithms;

import java.util.*;

public class CheapestFlightsWithinKStops {
    static class Node {
        int stops;
        int cost;
        int u;

        public Node(int stops, int cost, int u) {
            this.stops = stops;
            this.cost = cost;
            this.u = u;
        }
    }

    public static int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.stops));
        List<List<int[]>> adj = new ArrayList<>();
        int[] minCost = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        int maxStops = K + 1;
        q.add(new Node(0, 0, src));
        while (!q.isEmpty()) {
            Node top = q.poll();
            List<int[]> conn = adj.get(top.u);
            for (int[] ele : conn) {
                int v = ele[0];
                int cost = ele[1];
                if (top.cost + cost < minCost[v] && top.stops + 1 <= maxStops) {
                    minCost[v] = top.cost + cost;
                    q.add(new Node(top.stops + 1, minCost[v], v));
                }
            }
        }
        if (minCost[dst] == Integer.MAX_VALUE)
            return -1;
        return minCost[dst];
    }

    public static void main(String[] args) {
//        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
//        int n = 4, src = 0, dst = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int n = 3, src = 0, dst = 2, k = 1;
        System.out.println(CheapestFlight(n, flights, src, dst, k));
    }
}
