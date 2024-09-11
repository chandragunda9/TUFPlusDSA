package t9_greedy.scheduling;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int MaximumNonOverlappingIntervals(int[][] Intervals) {
        int n = Intervals.length;
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

    int method2(int[][] Intervals) {
        int size = Intervals.length, rem = 0;
        if (size <= 1)
            return 0;

        // Sort by minimum starting point
        Arrays.sort(Intervals, Comparator.comparingInt(o -> o[0]));

        int end = Intervals[0][1];
        for (int i = 1; i < Intervals.length; i++) {
            // If the current starting point is less than
            // the previous interval's ending point
            // (ie. there is an overlap)
            if (Intervals[i][0] < end) {
                // increase rem
                rem++;
                // Remove the interval
                // with the higher ending point
                end = Math.min(Intervals[i][1], end);
            } else
                end = Intervals[i][1];
        }

        return rem;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {1, 4}, {3, 8}, {3, 4}, {4, 5}};
        System.out.println(MaximumNonOverlappingIntervals(intervals));
    }
}
