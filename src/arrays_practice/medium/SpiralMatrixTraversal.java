package arrays_practice.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixTraversal {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int top = 0, down = n - 1, left = 0, right = m - 1;
        while (top <= down && left <= right) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= down) {
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[down][j]);
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrixTraversal obj = new SpiralMatrixTraversal();
        System.out.println(obj.spiralOrder(matrix));
    }
}
