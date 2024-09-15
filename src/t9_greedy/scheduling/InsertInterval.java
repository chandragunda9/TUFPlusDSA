package t9_greedy.scheduling;

import java.util.*;

public class InsertInterval {
    public static int[][] method1(int[][] Intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        List<int[]> changedIntervals = new ArrayList<>(Arrays.asList(Intervals));
        changedIntervals.add(newInterval);
        changedIntervals.sort(Comparator.comparingInt(a -> a[0]));

        ans.add(new int[]{changedIntervals.get(0)[0], changedIntervals.get(0)[1]});
        int lastEndTime = changedIntervals.get(0)[1];

        for (int i = 1; i < changedIntervals.size(); i++) {
            int startTime = changedIntervals.get(i)[0];
            int endTime = changedIntervals.get(i)[1];
            if (startTime <= lastEndTime) {
                int[] lastInterval = ans.get(ans.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], endTime);
                lastEndTime = lastInterval[1];
            } else {
                ans.add(new int[]{startTime, endTime});
                lastEndTime = endTime;
            }
        }
        return ans.toArray(int[][]::new);
    }

    //better way of implementing
    static int[][] insertNewInterval(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while (i < n) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insertNewInterval(intervals, newInterval)));
    }
}
