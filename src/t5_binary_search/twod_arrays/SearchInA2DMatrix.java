package t5_binary_search.twod_arrays;

public class SearchInA2DMatrix {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / m;
            int col = mid % m;
            if (mat[row][col] == target)
                return true;
            else if (target > mat[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean method2(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int midRow = (low + high) / 2;
            if (mat[midRow][0] == target || mat[midRow][m - 1] == target)
                return true;
            if (target > mat[midRow][0] && target < mat[midRow][m - 1]) {
                return binarySearch(mat[midRow], target);
            } else if (target < mat[midRow][0]) {
                high = midRow - 1;
            } else {
                low = midRow + 1;
            }
        }
        return false;
    }

    boolean binarySearch(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] == target)
                return true;
            if (target > row[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int target = 8;
        SearchInA2DMatrix obj = new SearchInA2DMatrix();
        System.out.println(obj.method2(mat, target));
    }
}
