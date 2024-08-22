package t3_arrays.medium;

import java.util.List;

public class RotateMatrixBy90 {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        //transposing the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //reversing each subarray
        for (int i = 0; i < n; i++) {
            int[] temp = matrix[i];
            reverse(temp, 0, n - 1);
        }
    }

    void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
