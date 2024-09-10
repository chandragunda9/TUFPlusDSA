package t9_greedy.scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static int MaximumNonOverlappingIntervals(int[][] Intervals) {
        int n = Intervals.length;
        Arrays.sort(Intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1, last = Intervals[0][1];
        for (int i = 0; i < n; i++) {
            int startTime = Intervals[i][0];
            int endTime = Intervals[i][1];
            if (startTime >= last) {
                count++;
                last = endTime;
            }
        }
        //Maximum no.of intervals can be array without overlapping
        System.out.println(count);
        //remaining intervals(i.e removed intervals)
        return n - count;
    }

    // Function to count the maximum number of non-overlapping intervals
    public static int method2(int[][] intervals) {
        // Sort the intervals based on their ending times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        // Get total number of intervals
        int n = intervals.length;

        // Initialize counter
        int cnt = 1;

        // Keep track of the ending time
        int lastEndTime = intervals[0][1];

        // Iterate through all intervals
        for (int i = 1; i < n; i++) {
            /* Check if the starting time of the current
            interval is greater than or equal to
            the ending time of the last
            selected interval */
            if (intervals[i][0] >= lastEndTime) {
                // Increment counter
                cnt++;
                // Update the ending time
                lastEndTime = intervals[i][1];
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 10}, {1, 4}, {3, 8}, {3, 4}, {4, 5}};
        System.out.println(MaximumNonOverlappingIntervals(intervals));
        System.out.println(method2(intervals));
    }
}
