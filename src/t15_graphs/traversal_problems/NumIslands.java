package t15_graphs.traversal_problems;

import java.util.LinkedList;
import java.util.Queue;

public class NumIslands {
    static class Cell {
        int row, col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '0', '1'}, {'1', '0', '0', '0', '0'}, {'1', '1', '1', '0', '1'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        Queue<Cell> q = new LinkedList<>();
        vis[row][col] = true;
        q.add(new Cell(row, col));
        while (!q.isEmpty()) {
            Cell rem = q.poll();
            int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1};
            int[] dCol = {0, 1, 1, 1, 0, -1, -1, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length &&
                        grid[nRow][nCol] == '1') {
                    if (!vis[nRow][nCol]) {
                        q.add(new Cell(nRow, nCol));
                        vis[nRow][nCol] = true;
                    }
                }
            }
        }
    }
}
