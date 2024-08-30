package t5_binary_search.twod_arrays;

public class MatrixMedian {
    int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int f(int[][] mat, int mid) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += upperBound(mat[i], mid);
        }
        return count;
    }

    public int findMedian(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][m - 1]);
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int noOfElementsLessThanEqualToMid = f(matrix, mid);
            if (noOfElementsLessThanEqualToMid > n * m / 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 4, 9}, {2, 5, 6}, {3, 8, 11}};
        MatrixMedian obj = new MatrixMedian();
        System.out.println(obj.findMedian(mat));
    }

    int median(int matrix[][], int R, int C) {
        //all rows are sorted
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][1]);
        }
        //need to find out howManyElements<=mid greater than R*C/2
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = f(matrix, mid);
            if (count > R * C / 2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int fun(int[][] mat, int mid) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            count += getUpperBound(mat[i], mid);
        }
        return count;
    }

    int getUpperBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
