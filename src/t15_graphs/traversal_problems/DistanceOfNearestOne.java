package t15_graphs.traversal_problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestOne {
    public static void main(String[] args) {
        int[][] grid = {{0, 0}, {0, 0}};
        System.out.println(Arrays.deepToString(nearest(grid)));
    }

    static class Cell {
        int row, col, dist;

        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public static int[][] method1(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] minDist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Cell(i, j, 0));
                    vis[i][j] = true;
                    minDist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        !vis[nRow][nCol]) {
                    minDist[nRow][nCol] = rem.dist + 1;
                    q.add(new Cell(nRow, nCol, minDist[nRow][nCol]));
                    vis[nRow][nCol] = true;
                }
            }
        }
        return minDist;
    }

    public static int[][] nearest(int[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        boolean anyOnes = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    anyOnes = true;
            }
        }
        if (!anyOnes)
            return grid;
        int[][] minDist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Cell(i, j, 0));
                    minDist[i][j] = 0;
                }
            }
        }
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        rem.dist + 1 < minDist[nRow][nCol]) {
                    minDist[nRow][nCol] = rem.dist + 1;
                    q.add(new Cell(nRow, nCol, minDist[nRow][nCol]));
                }
            }
        }
        return minDist;
    }
}
