package arrays.medium;

public class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix.length;
        //Transposing a matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reversing each array
        for (int i = 0; i < n; i++) {
            reverse(matrix[i], m);
        }
    }

    void reverse(int[] nums, int len) {
        int low = 0, high = len - 1;
        while (low < high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
