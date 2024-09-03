package t6_recursion.faq_hard;

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean isPossible(char[][] grid, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == digit || grid[i][col] == digit)
                return false;
        }

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isPossible(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();
        int[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        obj.solveSudoku(sudoku);
        System.out.println(Arrays.deepToString(sudoku));
    }

    public void solveSudoku(int[][] sudoku) {
        solveTheSudoku(sudoku);
    }

    boolean solveTheSudoku(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    for (int digit = 1; digit <= 9; digit++) {
                        if (isAllConditionsMet(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solveTheSudoku(board)) return true;
                            board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isAllConditionsMet(int[][] grid, int row, int col, int digit) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == digit || grid[i][col] == digit)
                return false;
        }

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (grid[i][j] == digit)
                    return false;
            }
        }
        return true;
    }
}
