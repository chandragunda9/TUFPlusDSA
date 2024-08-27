package t5_binary_search.twod_arrays;

public class RowWithMaximumOnes {
    int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int rowWithMax1s(int[][] mat) {
        int maxOnes = 0, maxInd = -1;
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int ones = m - lowerBound(mat[i], 1);
            if (ones > maxOnes) {
                maxOnes = ones;
                maxInd = i;
            }
        }
        return maxInd;
    }
}
