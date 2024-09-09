package GFGProblems.recursion;

import java.util.Arrays;

public class SudokuSolver {
    static boolean SolveSudoku(int grid[][]) {
        int row = 0, col = 0;
        int n = grid.length, m = grid[0].length;
        return solve(row, n, m, grid);
    }

    static boolean isPossible(int row, int col, int digit, int[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == digit || grid[i][col] == digit)
                return false;
        }
        int baseRow = row / 3 * 3, baseCol = col / 3 * 3;
        for (int i = baseRow; i < baseRow + 3; i++) {
            for (int j = baseCol; j < baseCol + 3; j++) {
                if (grid[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    static boolean solve(int row, int n, int m, int[][] grid) {
        for (int i = row; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    for (int digit = 1; digit <= 9; digit++) {
                        if (isPossible(i, j, digit, grid)) {
                            grid[i][j] = digit;
                            if (solve(i, n, m, grid))
                                return true;
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1,},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        SolveSudoku(grid);
        System.out.println(Arrays.deepToString(grid));
    }
}
