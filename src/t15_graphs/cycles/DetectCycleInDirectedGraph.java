package t15_graphs.cycles;

import java.util.*;
import java.util.stream.Collectors;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        int[][] arr = {{1}, {2, 5}, {3}, {4}, {1}, {}};
        List<Integer>[] adj = Arrays.stream(arr).map(a ->
                Arrays.stream(a).boxed().collect(Collectors.toList())).toArray(List[]::new);
        int n = 6;
        System.out.println(isCyclic(n, adj));
    }

    public static boolean isCyclic(int N, List<Integer>[] adj) {
        int[] inDeg = new int[N];
        for (int i = 0; i < N; i++) {
            List<Integer> conn = adj[i];
            for (int ele : conn) {
                inDeg[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            ans.add(rem);
            List<Integer> conn = adj[rem];
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0) {
                    q.add(ele);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (inDeg[i] != 0)
                return true;
        }
        return false;
    }
}
