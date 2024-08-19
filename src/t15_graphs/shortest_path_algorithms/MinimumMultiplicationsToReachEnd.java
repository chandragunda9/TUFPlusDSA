package t15_graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    public static void main(String[] args) {
        int start = 7, end = 66175;
        int[] arr = {3, 4, 65};
        System.out.println(minimumMultiplications(arr, start, end));
    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        int mod = (int) 1e5;
        int[] minSteps = new int[mod];
        Queue<int[]> q = new LinkedList<>();

        Arrays.fill(minSteps, Integer.MAX_VALUE);
        minSteps[start] = 0;
        q.add(new int[]{0, start});
        while (!q.isEmpty()) {
            int[] top = q.poll();
            if (top[1] == end)
                return top[0];
            for (int ele : arr) {
                int mul = top[1] * ele % mod;
                if (top[0] + 1 < minSteps[mul]) {
                    minSteps[mul] = top[0] + 1;
                    q.add(new int[]{minSteps[mul], mul});
                }
            }
        }
        return -1;
    }
}
