package t9_greedy.scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int MaximumNonOverlappingIntervals(int[][] Intervals) {
        if (Intervals == null || Intervals.length == 0)
            return 0;
        int n = Intervals.length;
        for (int i = 0; i < n; i++) {
            if (Intervals[i] == null || Intervals[i].length != 2)
                return 0;
        }
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1, last = Intervals[0][1];
        for (int i = 1; i < n; i++) {
            int startTime = Intervals[i][0];
            int endTime = Intervals[i][1];
            if (startTime >= last) {
                count++;
                last = endTime;
            }
        }
        //Maximum no.of intervals can be in array without overlapping
        System.out.println(count);
        //remaining intervals(i.e removed intervals)
        return n - count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {1, 4}, {3, 8}, {3, 4}, {4, 5}};
        System.out.println(MaximumNonOverlappingIntervals(intervals));
    }
}
