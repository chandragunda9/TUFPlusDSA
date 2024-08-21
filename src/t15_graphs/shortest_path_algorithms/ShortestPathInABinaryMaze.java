package t15_graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInABinaryMaze {
    static class Node {
        int i, j, dist;

        public Node(int i, int j, int dist) {
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }

    static int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length, m = grid[0].length;
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0)
            return -1;
        if (source[0] == destination[0] && source[1] == destination[1])
            return 0;
        int[][] minDist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(minDist[i], Integer.MAX_VALUE);
        }
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(source[0], source[1], 0));
        minDist[source[0]][source[1]] = 0;
        while (!q.isEmpty()) {
            Node top = q.poll();
            if (top.i == destination[0] && top.j == destination[1])
                return top.dist;
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = top.i + dRow[i];
                int nCol = top.j + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                        grid[nRow][nCol] == 1 && top.dist + 1 < minDist[nRow][nCol]) {
                    minDist[nRow][nCol] = top.dist + 1;
                    if (nRow == destination[0] && nCol == destination[1])
                        return minDist[nRow][nCol];
                    q.add(new Node(nRow, nCol, minDist[nRow][nCol]));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1}, {1, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}, {1, 0, 0, 1}};
        int[] source = {0, 1};
        int[] dst = {0, 1};
        System.out.println(shortestPath(grid, source, dst));
    }
}
