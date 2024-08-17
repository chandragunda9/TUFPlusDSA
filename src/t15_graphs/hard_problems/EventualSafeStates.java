package t15_graphs.hard_problems;

import java.util.*;

public class EventualSafeStates {
    public static void main(String[] args) {
        int v = 7;
        int[][] adj = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(Arrays.toString(eventualSafeNodes(v, adj)));
        System.out.println(Arrays.toString(method2(v, adj)));
    }

    public static int[] eventualSafeNodes(int V, int[][] adj) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] currVis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, currVis, vis, adj, ans);
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static boolean dfs(int v, boolean[] currVis, boolean[] vis, int[][] adj, List<Integer> ans) {
        vis[v] = true;
        currVis[v] = true;
        int[] conn = adj[v];
        for (int ele : conn) {
            if (!vis[ele]) {
                if (dfs(ele, currVis, vis, adj, ans))
                    return true;
            } else if (currVis[ele]) {
                return true;
            }
        }
        currVis[v] = false;
        ans.add(v);
        return false;
    }

    public static int[] method2(int V, int[][] adj) {
        List<List<Integer>> revAdj = reversedGraph(V, adj);
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] inDeg = new int[V];

        for (int i = 0; i < revAdj.size(); i++) {
            for (int ele : revAdj.get(i)) {
                inDeg[ele]++;
            }
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = revAdj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    static List<List<Integer>> reversedGraph(int V, int[][] adj) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int u = 0; u < V; u++) {
            for (int v : adj[u]) {
                revAdj.get(v).add(u);
            }
        }
        return revAdj;
    }
}
