package t9_greedy.scheduling;

import java.util.Arrays;

public class JobSequencingProblem {
    //basically not two different methods, just implementation different
    public static int[] method1(int[][] Jobs) {
        //sorting according to more profit
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
        int maxDeadline = 0;
        for (int i = 0; i < Jobs.length; i++) {
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }
        int[] sch = new int[maxDeadline + 1];
        Arrays.fill(sch, -1);
        int maxProfit = 0, count = 0;
        for (int i = 0; i < Jobs.length; i++) {
            int jobId = Jobs[i][0];
            int deadline = Jobs[i][1];
            int profit = Jobs[i][2];

            int ind = deadline;
            while (ind >= 0 && sch[ind] != -1) {
                ind--;
            }
            if (ind > 0) {
                sch[ind] = jobId;
                count++;
                maxProfit = maxProfit + profit;
            }
        }
        int[] ans = new int[2];
        ans[0] = count;
        ans[1] = maxProfit;
        return ans;
    }

    public static int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a, b) -> b[2] - a[2]);
        int n = Jobs.length;
        int[] hash = new int[n];
        Arrays.fill(hash, -1);

        int maxProfit = 0, count = 0;
        for (int i = 0; i < n; i++) {
            int jobId = Jobs[i][0];
            int deadline = Jobs[i][1];
            int profit = Jobs[i][2];

            for (int j = deadline - 1; j >= 0; j--) {
                if (hash[j] == -1) {
                    hash[j] = jobId;
                    count++;
                    maxProfit += profit;
                    break;
                }
            }
        }
        return new int[]{count, maxProfit};
    }

    public static void main(String[] args) {
        int[][] jobs = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}};
        System.out.println(Arrays.toString(JobScheduling(jobs)));
    }
}
