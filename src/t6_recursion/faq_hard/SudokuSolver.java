package t6_recursion.faq_hard;

import java.util.Arrays;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solve(0, board);
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

    boolean solve(int row, char[][] board) {
        for (int i = row; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isPossible(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solve(i, board)) return true;
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
        System.out.println(Arrays.deepToString(sudoku));
        obj.solveSudoku(sudoku);
        System.out.println(Arrays.deepToString(sudoku));
    }

    public void solveSudoku(int[][] sudoku) {
        solveTheSudoku(0, sudoku);
    }

    boolean isAllConditionsMet(int row, int col, int[][] sudoku, int digit) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == digit || sudoku[i][col] == digit)
                return false;
        }
        int baseRow = row / 3 * 3, baseCol = col / 3 * 3;
        for (int i = baseRow; i < baseRow + 3; i++) {
            for (int j = baseCol; j < baseCol + 3; j++) {
                if (sudoku[i][j] == digit)
                    return false;
            }
        }
        return true;
    }

    boolean solveTheSudoku(int start, int[][] sudoku) {
        for (int row = start; row < sudoku.length; row++) {
            for (int col = 0; col < sudoku[0].length; col++) {
                if (sudoku[row][col] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (isAllConditionsMet(row, col, sudoku, i)) {
                            sudoku[row][col] = i;
                            if (solveTheSudoku(row, sudoku)) return true;
                            sudoku[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
