package t9_greedy.scheduling;

import java.util.Arrays;

public class ShortestJobFirst {
    public long solve(int[] bt) {
        Arrays.sort(bt);
        long waitingTime = 0;
        long totalTime = 0;
        for (int i = 0; i < bt.length; i++) {
            waitingTime += totalTime;
            totalTime += bt[i];
        }
        return waitingTime / bt.length;
    }
}
