package binary_search.two_d_arrays;

public class FindPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rowInd = findMaxEleInd(mat, mid);
            int currEle = mat[rowInd][mid];
            int prevEle = mid > 0 ? mat[rowInd][mid - 1] : -1;
            int nextEle = mid == mat[0].length - 1 ? -1 : mat[rowInd][mid + 1];
            if (currEle > prevEle && currEle > nextEle) {
                return new int[]{rowInd, mid};
            } else if (prevEle > currEle) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }

    int findMaxEleInd(int[][] mat, int col) {
        int maxEle = Integer.MIN_VALUE, ind = -1;
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][col] > maxEle) {
                maxEle = mat[i][col];
                ind = i;
            }
        }
        return ind;
    }
}
