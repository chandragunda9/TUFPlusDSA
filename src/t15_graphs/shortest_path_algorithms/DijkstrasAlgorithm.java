package t15_graphs.shortest_path_algorithms;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstrasAlgorithm {
    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", dist=" + dist +
                    '}';
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

    public int[] dijkstraUsingSet(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        int mod = (int) 1e9;
        TreeSet<Node> se = new TreeSet<>(Comparator.comparingInt(a -> a.dist));

        Arrays.fill(minDist, mod);
        minDist[S] = 0;
        se.add(new Node(S, 0));
        while (!se.isEmpty()) {
            Node top = se.pollFirst();
            ArrayList<ArrayList<Integer>> conn = adj.get(top.node);
            for (ArrayList<Integer> it : conn) {
                int v = it.get(0);
                int we = it.get(1);
                if (top.dist + we < minDist[v]) {
                    if (minDist[v] != mod) {
                        se.remove(new Node(v, minDist[v]));
                    }
                    minDist[v] = top.dist + we;
                    se.add(new Node(v, minDist[v]));
                }
            }
        }
        return minDist;
    }

    public int[] dijkstraUsingSetArr(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        int[] minDist = new int[V];
        int mod = (int) 1e9;
        TreeSet<int[]> se = new TreeSet<>(Comparator.comparingInt(a -> a[0]));

        Arrays.fill(minDist, mod);
        minDist[S] = 0;
        se.add(new int[]{0, S});
        while (!se.isEmpty()) {
            int[] top = se.pollFirst();
            ArrayList<ArrayList<Integer>> conn = adj.get(top[1]);
            for (ArrayList<Integer> it : conn) {
                int v = it.get(0);
                int we = it.get(1);
                if (top[0] + we < minDist[v]) {
                    if (minDist[v] != mod) {
                        se.remove(new int[]{minDist[v], v});
                    }
                    minDist[v] = top[0] + we;
                    se.add(new int[]{minDist[v], v});
                }
            }
        }
        return minDist;
    }

    public static void main(String[] args) {
        DijkstrasAlgorithm obj = new DijkstrasAlgorithm();
        int[][][] arr = {{{3, 1}, {2, 1}, {1, 9}}, {{0, 9}, {3, 2}}, {{0, 1}, {3, 2}}, {{0, 1}, {2, 2}, {1, 3}}};
        int v = 4, src = 0;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = Arrays.stream(arr).map(
                ar -> Arrays.stream(ar).map(
                        a -> Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new))
                ).collect(Collectors.toCollection(ArrayList::new))
        ).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(Arrays.toString(obj.dijkstraUsingSet(v, adj, src)));
        System.out.println(Arrays.toString(obj.dijkstraUsingSetArr(v, adj, src)));
    }
}
