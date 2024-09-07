package GFGProblems.recursion;

public class SudokuSolver {
    static boolean SolveSudoku(int sudoku[][]) {
        for (int row = 0; row < sudoku.length; row++) {
            for (int col = 0; col < sudoku[0].length; col++) {
                if (sudoku[row][col] == 0) {
                    for (int i = 1; i <= 9; i++) {
                        if (isAllConditionsMet(row, col, sudoku, i)) {
                            sudoku[row][col] = i;
                            if (SolveSudoku(sudoku)) return true;
                            sudoku[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    static boolean isAllConditionsMet(int row, int col, int[][] sudoku, int digit) {
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

    static void printGrid(int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
