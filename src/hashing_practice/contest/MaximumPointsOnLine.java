package hashing_practice.contest;

import java.util.HashMap;
import java.util.Map;

public class MaximumPointsOnLine {
    public int maximumPointsOnALine(int[][] nums) {
        int n = nums.length, maxPoints = 0;
        for (int i = 0; i < n; i++) {
            int overlap = 0, localMax = 0;
            Map<String, Integer> slopeCounts = new HashMap<>();

            for (int j = i + 1; j < n; j++) {
                int dx = nums[j][0] - nums[i][0];
                int dy = nums[j][1] - nums[i][1];

                if (dx == 0 && dy == 0) {
                    overlap++;
                    continue;
                }

                int gcdValue = gcd(dx, dy);
                dx /= gcdValue;
                dy /= gcdValue;
                String key = dx + "," + dy;
                slopeCounts.put(key, slopeCounts.getOrDefault(key, 0) + 1);
                localMax = Math.max(localMax, slopeCounts.get(key));
            }
            maxPoints = Math.max(maxPoints, localMax + overlap + 1);
        }
        return maxPoints;
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
