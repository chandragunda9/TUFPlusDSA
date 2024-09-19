package t15_graphs.other_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class KosarajusAlgorithm {
    public static void main(String[] args) {
        int[][] arr = {{2, 3}, {0}, {1}, {4}, {}};
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = Arrays.stream(arr).map(a -> Arrays.stream(a).boxed().collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));
        KosarajusAlgorithm obj = new KosarajusAlgorithm();
        System.out.println(obj.kosaraju(v, adj));
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs1(i, vis, adj, st);
            }
        }
        List<List<Integer>> revAdj = reverseGraph(V, adj, vis);
        int noOfStronglyConnectedComponents = 0;
        while (!st.isEmpty()) {
            int top = st.pop();
            if (!vis[top]) {
                dfs2(top, vis, revAdj);
                noOfStronglyConnectedComponents++;
            }
        }
        return noOfStronglyConnectedComponents;
    }

    List<List<Integer>> reverseGraph(int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        List<List<Integer>> revAdj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            revAdj.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            vis[i] = false;
            List<Integer> conn = adj.get(i);
            for (int ele : conn) {
                revAdj.get(ele).add(i);
            }
        }
        return revAdj;
    }


    void dfs1(int v, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[v] = true;
        ArrayList<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs1(ele, vis, adj, st);
            }
        }
        st.push(v);
    }

    void dfs2(int v, boolean[] vis, List<List<Integer>> adj) {
        vis[v] = true;
        List<Integer> conn = adj.get(v);
        for (int ele : conn) {
            if (!vis[ele]) {
                dfs2(ele, vis, adj);
            }
        }
    }
}
