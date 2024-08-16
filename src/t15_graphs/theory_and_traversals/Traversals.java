package t15_graphs.theory_and_traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public List<Integer> dfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        dfs(0, vis, adj, ans);
        return ans;
    }

    void dfs(int v, boolean[] vis, List<Integer>[] adj, List<Integer> ans) {
        vis[v] = true;
        ans.add(v);
        List<Integer> conn = adj[v];
        for (Integer ele : conn) {
            if (!vis[ele]) {
                dfs(ele, vis, adj, ans);
            }
        }
    }

    public List<Integer> bfsOfGraph(int V, List<Integer> adj[]) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj[rem];
            for (Integer ele : conn) {
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        return ans;
    }
}
