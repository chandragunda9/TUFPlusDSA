package t6_recursion.faq_hard;

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        int row = 0, col = 0;
        solve(board, row, col);
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

    boolean solve(char[][] board, int row, int col) {
        for (int i = row; i < board.length; i++) {
            for (int j = col; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char digit = '0'; digit <= '9'; digit++) {
                        if (isPossible(board, i, j, digit)) {
                            board[i][j] = digit;
                            if (solve(board, i, j)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }
}
