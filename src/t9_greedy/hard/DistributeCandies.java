package t9_greedy.hard;

public class DistributeCandies {
    public int method1(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n], right = new int[n];
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    public int method2(int[] ratings) {
        //Just removing O(n) space in method1 (using O(2n))
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int sum = Math.max(1, left[n - 1]);
        int curr, right = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                curr = right + 1;

            } else {
                curr = 1;
            }
            right = curr;
            sum += Math.max(left[i], curr);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 7, 6, 5, 4, 3, 2, 1, 1, 1, 2, 3, 4, 2, 1, 1, 1};
        DistributeCandies obj = new DistributeCandies();
        System.out.println(obj.method2(arr));
        System.out.println(obj.candy(arr));
    }

    public int candy(int[] ratings) {
        int i = 1, n = ratings.length, sum = 1;
        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                sum += 1;
                i++;
                continue;
            }
            int peak = 1;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }
            int down = 1;
            while (i < n && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }
            if (down > peak) {
                sum += down - peak;
            }
        }
        return sum;
    }
}
