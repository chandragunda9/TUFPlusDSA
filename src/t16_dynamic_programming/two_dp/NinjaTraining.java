package t16_dynamic_programming.two_dp;

import java.util.Arrays;

public class NinjaTraining {
    public int ninjaTraining(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[4];
        prev[0] = Math.max(matrix[0][1], matrix[0][2]);
        prev[1] = Math.max(matrix[0][0], matrix[0][2]);
        prev[2] = Math.max(matrix[0][0], matrix[0][1]);
        prev[3] = Math.max(matrix[0][2], Math.max(matrix[0][0], matrix[0][1]));

        for (int day = 1; day < n; day++) {
            int[] curr = new int[4];
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                curr[lastTask] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (lastTask != task) {
                        int points = matrix[day][task] + prev[task];
                        curr[lastTask] = Math.max(curr[lastTask], points);
                    }
                }
            }
            prev = curr;
        }
        return prev[3];
    }

    public int method2(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(matrix[0][1], matrix[0][2]);
        dp[0][1] = Math.max(matrix[0][0], matrix[0][2]);
        dp[0][2] = Math.max(matrix[0][0], matrix[0][1]);
        dp[0][3] = Math.max(matrix[0][2], Math.max(matrix[0][0], matrix[0][1]));
        for (int day = 1; day < n; day++) {
            for (int lastTask = 0; lastTask < 4; lastTask++) {
                dp[day][lastTask] = 0;
                for (int task = 0; task < 3; task++) {
                    if (lastTask != task) {
                        int points = matrix[day][task] + dp[day - 1][task];
                        dp[day][lastTask] = Math.max(dp[day][lastTask], points);
                    }
                }
            }
        }
        return dp[n - 1][3];
    }

    public int method1(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(n - 1, 3, matrix, dp);
    }

    int solve(int day, int lastTaskDone, int[][] mat, int[][] dp) {
        if (day == 0) {
            int maxPoints = 0;
            for (int task = 0; task < 3; task++) {
                if (lastTaskDone != task) {
                    int points = mat[0][task];
                    maxPoints = Math.max(maxPoints, points);
                }
            }
            return maxPoints;
        }
        if (dp[day][lastTaskDone] != -1)
            return dp[day][lastTaskDone];
        int maxPoints = 0;
        for (int task = 0; task < 3; task++) {
            if (task != lastTaskDone) {
                int points = mat[day][task] + solve(day - 1, task, mat, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return dp[day][lastTaskDone] = maxPoints;
    }

    public static void main(String[] args) {
        int[][] mat = {{10, 40, 70}, {20, 50, 80}, {30, 60, 90}};
        NinjaTraining obj = new NinjaTraining();
        System.out.println(obj.method1(mat));
        System.out.println(obj.method2(mat));
        System.out.println(obj.ninjaTraining(mat));
    }


//    public int method1(int[][] matrix) {
//        int n = matrix.length;
//        int[][] dp = new int[n][4];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
//        int res = solve(matrix, 0, 3, dp);
//        return res;
//    }
//
//    int solve(int[][] mat, int day, int lastTaskDone, int[][] dp) {
//        if (day == mat.length)
//            return 0;
//        if (dp[day][lastTaskDone] != -1)
//            return dp[day][lastTaskDone];
//        int maxPoints = 0;
//        for (int task = 0; task < 3; task++) {
//            int points = 0;
//            if (lastTaskDone != task)
//                points = mat[day][task] + solve(mat, day + 1, task, dp);
//            maxPoints = Math.max(maxPoints, points);
//        }
//        return dp[day][lastTaskDone] = maxPoints;
//    }
}
