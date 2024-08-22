package t15_graphs.theory_and_traversals;

import java.util.*;
import java.util.stream.Collectors;

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
        int whileCount = 0, forCount = 0;
        while (!q.isEmpty()) {
            whileCount++;
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj[rem];
            for (Integer ele : conn) {
                forCount++;
                if (!vis[ele]) {
                    q.add(ele);
                    vis[ele] = true;
                }
            }
        }
        System.out.println(whileCount+" "+forCount);
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4}, {3, 4, 0}, {0}, {1}, {0, 1}};
        int V = 5;
        List<Integer>[] adj = Arrays.stream(arr).map(a ->
                Arrays.stream(a).boxed().collect(Collectors.toList())).toArray(List[]::new);
        Traversals obj = new Traversals();
        System.out.println(obj.bfsOfGraph(V, adj));
    }
}
