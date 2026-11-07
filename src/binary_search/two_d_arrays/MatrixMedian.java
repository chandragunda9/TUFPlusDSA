package binary_search.two_d_arrays;

public class MatrixMedian {
    public int findMedian(int[][] matrix) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int smallerEquals = countSmallerEquals(matrix, mid);
            if (smallerEquals > n * m / 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    int countSmallerEquals(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int ub = upperBound(matrix[i], mid);
            count += ub;
        }
        return count;
    }

    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
