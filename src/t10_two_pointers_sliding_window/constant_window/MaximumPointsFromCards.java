package t10_two_pointers_sliding_window.constant_window;

public class MaximumPointsFromCards {
    public int method1(int[] cardScore, int k) {
        int[] ans = new int[1];
        int l = 0, r = cardScore.length - 1;
        getMaxPoints(l, r, cardScore, k, 0, ans);
        return ans[0];
    }

    void getMaxPoints(int l, int r, int[] arr, int k, int sum, int[] ans) {
        if (k == 0) {
            ans[0] = Math.max(ans[0], sum);
            return;
        }
        //picking lth card
        getMaxPoints(l + 1, r, arr, k - 1, sum + arr[l], ans);
        //picking rth card
        getMaxPoints(l, r - 1, arr, k - 1, sum + arr[r], ans);
    }

    public int maxScore(int[] cardScore, int k) {
        int leftIndex = 0, rightIndex = cardScore.length - 1;
        int maxScore = 0, lsum = 0, rsum = 0;

        while (leftIndex < k) {
            lsum += cardScore[leftIndex];
            leftIndex++;
        }
        maxScore = Math.max(maxScore, lsum);

        for (leftIndex = k - 1; leftIndex >= 0; leftIndex--) {
            lsum -= cardScore[leftIndex];
            rsum += cardScore[rightIndex];
            maxScore = Math.max(maxScore, lsum + rsum);
            rightIndex--;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] points = {1, 2, 3, 4, 5, 6};
        int k = 3;
//        int[] points = {5, 4, 1, 8, 7, 1, 3};
//        int k = 3;
        MaximumPointsFromCards obj = new MaximumPointsFromCards();
        System.out.println(obj.maxScore(points, k));
    }
}
