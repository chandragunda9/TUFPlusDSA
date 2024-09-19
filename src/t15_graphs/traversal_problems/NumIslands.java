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

    public static int method1(char[][] grid) {
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

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '1', '0'},
                {'0', '0', '0', '1', '1'},
                {'0', '1', '1', '0', '0'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '1', '0', '0'}};
        System.out.println(numIslands(grid));
    }

    static class DisjointSet {
        int[] parent;
        int[] sizes;

        DisjointSet(int n) {
            parent = new int[n + 1];
            sizes = new int[n + 1];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                sizes[i] = 1;
            }
        }

        int findParent(int node) {
            if (node == parent[node])
                return node;
            return parent[node] = findParent(parent[node]);
        }

        void unionBySize(int u, int v) {
            int rootU = findParent(u);
            int rootV = findParent(v);
            if (rootU == rootV)
                return;
            if (sizes[rootU] < sizes[rootV]) {
                parent[rootU] = rootV;
                sizes[rootV] += sizes[rootU];
            } else {
                parent[rootV] = rootU;
                sizes[rootU] += sizes[rootV];
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        DisjointSet dis = new DisjointSet(n * m);
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] != '0') {
                    grid[row][col] = '2';
                    traverseNeighbors(row, col, grid, dis);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nodeNo = m * i + j;
                if (grid[i][j] != '0' && dis.findParent(nodeNo) == nodeNo) {
                    count++;
                }
            }
        }
        return count;
    }

    static boolean isValid(int row, int col, int n, int m, char[][] grid) {
        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] != '0';
    }

    static void traverseNeighbors(int row, int col, char[][] grid, DisjointSet dis) {
        int n = grid.length, m = grid[0].length;
        for (int dRow = -1; dRow <= 1; dRow++) {
            for (int dCol = -1; dCol <= 1; dCol++) {
                if (dRow == 0 && dCol == 0)
                    continue;
                int nRow = row + dRow;
                int nCol = col + dCol;
                if (isValid(nRow, nCol, n, m, grid)) {
                    int nodeNo = m * row + col;
                    int adjNodeNo = m * nRow + nCol;
                    grid[nRow][nCol] = '2';
                    dis.unionBySize(nodeNo, adjNodeNo);
                }
            }
        }
    }
}
