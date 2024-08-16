package t15_graphs.traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Cell {
        int row, col, time;

        public Cell(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new Cell(i, j, 0));
            }
        }
        int maxTime = 0;
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            maxTime = Math.max(maxTime, rem.time);
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < grid.length &&
                        nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1) {
                    q.add(new Cell(nRow, nCol, rem.time + 1));
                    grid[nRow][nCol] = 2;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }
        return maxTime;
    }
}
