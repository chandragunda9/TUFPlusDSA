package t15_graphs.shortest_path_algorithms;

import java.util.*;

public class PathWithMinimumEffort {
    static class Node {
        int row, col, maxDiffAlongPath;

        public Node(int row, int col, int maxDiffAlongPath) {
            this.row = row;
            this.col = col;
            this.maxDiffAlongPath = maxDiffAlongPath;
        }
    }

    static boolean isValid(int nRow, int nCol, int rows, int columns) {
        return nRow >= 0 && nRow < rows && nCol >= 0 && nCol < columns;
    }

    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.maxDiffAlongPath));
        int[][] minEffort = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }
        pq.add(new Node(0, 0, 0));
        minEffort[0][0] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = top.row + dRow[i];
                int nCol = top.col + dCol[i];
                if (isValid(nRow, nCol, rows, columns)) {
                    int absDiff = Math.abs(heights[top.row][top.col] - heights[nRow][nCol]);
                    int newMaxDiff = Math.max(top.maxDiffAlongPath, absDiff);
                    if (newMaxDiff < minEffort[nRow][nCol]) {
                        minEffort[nRow][nCol] = newMaxDiff;
                        pq.add(new Node(nRow, nCol, newMaxDiff));
                    }
                }
            }
        }
        return minEffort[rows - 1][columns - 1];
    }
}
