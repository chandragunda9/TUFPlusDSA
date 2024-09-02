package t6_recursion.faq_hard;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
    public List<String> findPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        ArrayList<String> ans = new ArrayList<>();
        if (grid[0][0] == 0 || grid[n - 1][m - 1] == 0)
            return ans;
        String currPath = "";
        solve(0, 0, n, m, currPath, grid, ans);
        return ans;
    }

    void solve(int row, int col, int n, int m, String currPath, int[][] grid, List<String> ans) {
        if (row == n - 1 && col == m - 1) {
            ans.add(currPath);
            return;
        }
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] != 1)
            return;
        grid[row][col] = 2;
        solve(row, col - 1, n, m, currPath + "L", grid, ans);
        solve(row - 1, col, n, m, currPath + "U", grid, ans);
        solve(row, col + 1, n, m, currPath + "R", grid, ans);
        solve(row + 1, col, n, m, currPath + "D", grid, ans);
        grid[row][col] = 1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0}, {1, 1, 0}, {0, 1, 1}};
        RatInAMaze obj = new RatInAMaze();
        System.out.println(obj.findPath(grid));
    }
}
