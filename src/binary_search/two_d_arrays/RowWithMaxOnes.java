package binary_search.two_d_arrays;

public class RowWithMaxOnes {
    public int rowWithMax1s1(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int ans = -1, maxCount = 0;
        for (int i = 0; i < n; i++) {
            int lb = lowerBound(mat[i]);
            if (m - lb > maxCount) {
                ans = i;
                maxCount = m - lb;
            }
        }
        return ans;
    }

    int lowerBound(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int rowWithMax1s(int[][] mat) {
        int row = 0, col = mat[0].length - 1, ans = -1;
        while (row < mat.length && col >= 0) {
            if (mat[row][col] == 1) {
                col--;
                ans = row;
            } else {
                row++;
            }
        }
        return ans;
    }
}
