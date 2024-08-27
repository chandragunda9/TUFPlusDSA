package t5_binary_search.twod_arrays;

public class SearchInA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
