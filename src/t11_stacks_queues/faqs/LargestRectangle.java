package t11_stacks_queues.faqs;

import java.util.Stack;

public class LargestRectangle {
    public int maximalAreaOfSubMatrixOfAll1(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] prefixSums = new int[n][m];

        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[i][j];
                if (matrix[i][j] == 0) {
                    prefixSums[i][j] = 0;
                    sum = 0;
                } else {
                    prefixSums[i][j] = sum;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, largestRectangleArea(prefixSums[i]));
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        //use of the concept of pse
        int n = heights.length;
        Stack<Integer> pseStack = new Stack<>();
        int largest = 0;
        for (int i = 0; i < n; i++) {
            while (!pseStack.isEmpty() && heights[pseStack.peek()] >= heights[i]) {
                int poppedEleInd = pseStack.pop();
                int nextSmallerEleInd = i;
                int prevSmallerEleInd = pseStack.isEmpty() ? -1 : pseStack.peek();
                largest = Math.max(largest,
                        heights[poppedEleInd] * (nextSmallerEleInd - prevSmallerEleInd - 1));
            }
            pseStack.push(i);
        }

        while (!pseStack.isEmpty()) {
            int popInd = pseStack.pop();
            int nextSmallerEleInd = n;
            int prevSmallerEleInd = pseStack.isEmpty() ? -1 : pseStack.peek();
            largest = Math.max(largest,
                    heights[popInd] * (nextSmallerEleInd - prevSmallerEleInd - 1));
        }
        return largest;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        LargestRectangle obj = new LargestRectangle();
        System.out.println(obj.maximalAreaOfSubMatrixOfAll1(mat));
    }
}
