package t15_graphs.hard_problems_2;

import java.util.HashSet;
import java.util.Set;

public class MakingALargeIsland {
    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet dis = new DisjointSet(n * n);

        //step 1
        //initialising islands
        addInitialIslands(grid, n, dis, dRow, dCol);

        //step 2
        int largeIsland = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1)
                    continue;
                Set<Integer> comps = new HashSet<>();
                for (int i = 0; i < dRow.length; i++) {
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];
                    if (isValid(n, nRow, nCol)) {
                        if (grid[nRow][nCol] == 1) {
                            int adjNodeNo = nRow * n + nCol;
                            comps.add(dis.findParent(adjNodeNo));
                        }
                    }
                }
                int size = 1;
                for (Integer a : comps) {
                    size += dis.sizes[a];
                }
                largeIsland = Math.max(largeIsland, size);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nodeNo = i * n + j;
                largeIsland = Math.max(largeIsland, dis.sizes[nodeNo]);
            }
        }
        return largeIsland;
    }

    private static boolean isValid(int n, int nRow, int nCol) {
        return nRow >= 0 && nRow < n && nCol >= 0 && nCol < n;
    }

    private static void addInitialIslands(int[][] grid, int n, DisjointSet dis, int[] dRow, int[] dCol) {
        boolean[][] vis = new boolean[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0 || vis[row][col])
                    continue;
                vis[row][col] = true;
                for (int i = 0; i < dRow.length; i++) {
                    int nRow = row + dRow[i];
                    int nCol = col + dCol[i];
                    if (isValid(n, nRow, nCol)) {
                        if (grid[nRow][nCol] == 1) {
                            int nodeNo = row * n + col;
                            int adjNodeNo = nRow * n + nCol;
                            dis.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        MakingALargeIsland ob = new MakingALargeIsland();
        int[][] grid = {{0}};
        System.out.println(ob.largestIsland(grid));
    }
}
