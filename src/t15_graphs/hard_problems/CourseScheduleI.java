package t15_graphs.hard_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleI {
    public boolean canFinish(int N, int[][] arr) {
        //By using Kahn's Algorithm
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDeg = new int[N];

        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : arr) {
            adj.get(a[1]).add(a[0]);
            inDeg[a[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            Integer rem = q.poll();
            List<Integer> conn = adj.get(rem);
            for (int ele : conn) {
                inDeg[ele]--;
                if (inDeg[ele] == 0)
                    q.add(ele);
            }
        }
        for (int i = 0; i < inDeg.length; i++) {
            if (inDeg[i] != 0)
                return false;
        }
        return true;
    }
}
