package binary_search.two_d_arrays;

public class SearchInA2DMatrixI {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length, low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] == target)
                return true;
            else if (target < mat[row][col]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
