package t15_graphs.mst;

import java.util.*;

public class PrimsAlgorithm {
    static class Node {
        int weight;
        int u;
        int parent;

        public Node(int weight, int u, int parent) {
            this.weight = weight;
            this.u = u;
            this.parent = parent;
        }
    }

    public int spanningTree(int V, List<List<List<Integer>>> adj) {
        List<List<Integer>> mst = new ArrayList<>();
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        boolean[] vis = new boolean[V];
        int sum = 0;

        q.add(new Node(0, 0, -1));
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (vis[top.u])
                continue;
            vis[top.u] = true;
            if (top.parent != -1) {
                sum += top.weight;
                mst.add(new ArrayList<>(Arrays.asList(top.u, top.parent)));
            }
            List<List<Integer>> conn = adj.get(top.u);
            for (List<Integer> ele : conn) {
                if (!vis[ele.get(0)]) {
                    q.add(new Node(ele.get(1), ele.get(0), top.u));
                }
            }
        }
        System.out.println(mst);
        return sum;
    }
}
