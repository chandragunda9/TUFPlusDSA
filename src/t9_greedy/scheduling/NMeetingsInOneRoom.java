package t9_greedy.scheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NMeetingsInOneRoom {
    public static class MeetingComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[1], o2[1]);
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        int[][] timeAndIndex = new int[n][3];
        for (int i = 0; i < n; i++) {
            timeAndIndex[i][0] = start[i];
            timeAndIndex[i][1] = end[i];
            timeAndIndex[i][2] = i;
        }
        Arrays.sort(timeAndIndex, Comparator.comparingInt(a -> a[1]));
//        Arrays.sort(timeAndIndex, new MeetingComparator());

        List<Integer> seq = new ArrayList<>();

        int last = -1, count = 0;
        for (int i = 0; i < n; i++) {
            int startTime = timeAndIndex[i][0];
            int endTime = timeAndIndex[i][1];
            int index = timeAndIndex[i][2];
            if (startTime > last) {
                count++;
                last = endTime;
                seq.add(index);
            }
        }
        System.out.println(seq);
        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 4, 6, 9};
        int[] end = {2, 5, 7, 12};
        System.out.println(maxMeetings(start, end));
    }
}
