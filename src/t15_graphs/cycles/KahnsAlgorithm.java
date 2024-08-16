package t15_graphs.cycles;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {
    public int[] topoSort(int V, List<Integer>[] adj) {
        int[] inDeg = new int[V];
        for (int i = 0; i < V; i++) {
            List<Integer> conn = adj[i];
            for (int ele : conn) {
                inDeg[ele]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
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
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
