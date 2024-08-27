package t5_binary_search.twod_arrays;

public class FindPeakElementII {
    int getMax(int[][] mat, int col, int n) {
        int maxEle = Integer.MIN_VALUE, maxInd = -1;
        for (int row = 0; row < n; row++) {
            if (mat[row][col] > maxEle) {
                maxEle = mat[row][col];
                maxInd = row;
            }
        }
        return maxInd;
    }

    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxEleRowInd = getMax(mat, mid, n);
            int curr = mat[maxEleRowInd][mid];
            int leftEle = mid > 0 ? mat[maxEleRowInd][mid - 1] : -1;
            int rightEle = mid < m - 1 ? mat[maxEleRowInd][mid + 1] : -1;
            if (curr > leftEle && curr > rightEle)
                return new int[]{maxEleRowInd, mid};
            else if (leftEle > curr) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
