package t9_greedy.scheduling;

import java.util.Arrays;

public class MinimumPlatforms {
    public int method1(int[] arr, int[] dept) {
        int n = arr.length, maxCount = 0;
        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (i != j && isIntersected(i, j, arr, dept)) {
                    count++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public boolean isIntersected(int i, int j, int[] arr, int[] dep) {
        return arr[i] >= arr[j] && arr[i] <= dep[j];
    }

    public int findPlatform(int[] arr, int[] dept) {
        Arrays.sort(arr);
        Arrays.sort(dept);
        int i = 0, j = 0, n = arr.length;
        int count = 0, ans = 0;
        while (i < n && j < n) {
            if (arr[i] <= dept[j]) {
                i += 1;
                count++;
            } else {
                j += 1;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {900, 1000, 1200}, dept = {1000, 1200, 1240};
        MinimumPlatforms obj = new MinimumPlatforms();
        System.out.println(obj.findPlatform(arr, dept));
    }
}
