package GFGProblems.recursion;

import java.util.ArrayList;

public class RatInAMaze {
    public ArrayList<String> findPath(int[][] grid) {
        ArrayList<String> ans = new ArrayList<>();
        int n = grid.length, m = grid[0].length;
        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0)
            return ans;
        solve(0, 0, n, m, "", grid, ans);
        return ans;
    }

    void solve(int row, int col, int n, int m, String curr, int[][] grid, ArrayList<String> ans) {
        if (row == n - 1 && col == m - 1) {
            ans.add(curr);
            return;
        }
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1)
            return;
        grid[row][col] = 2;
        solve(row, col - 1, n, m, curr + 'L', grid, ans);
        solve(row - 1, col, n, m, curr + 'U', grid, ans);
        solve(row, col + 1, n, m, curr + 'R', grid, ans);
        solve(row + 1, col, n, m, curr + 'D', grid, ans);
        grid[row][col] = 1;
    }
}
