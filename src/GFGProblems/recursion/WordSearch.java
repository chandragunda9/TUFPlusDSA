package GFGProblems.recursion;

public class WordSearch {
    int[] dRow = {-1, 0, 1, 0};
    int[] dCol = {0, 1, 0, -1};

    public boolean isWordExist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check(0, i, j, n, m, word, board))
                    return true;
            }
        }
        return false;
    }

    boolean isValid(int row, int col, int n, int m, char[][] board) {
        return row >= 0 && row < n && col >= 0 && col < m && board[row][col] != '.';
    }

    boolean check(int ind, int row, int col, int n, int m, String word, char[][] board) {
        if (ind == word.length())
            return true;
        if (word.charAt(ind) == board[row][col]) {
            if (ind == word.length() - 1)
                return true;
            char ch = board[row][col];
            board[row][col] = '.';
            for (int i = 0; i < dRow.length; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (isValid(nRow, nCol, n, m, board)) {
                    if (check(ind + 1, nRow, nCol, n, m, word, board)) {
                        return true;
                    }
                }
            }
            board[row][col] = ch;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
        char[][] board = {{'A'}};
        String word = "AB";
        WordSearch obj = new WordSearch();
        System.out.println(obj.isWordExist(board, word));
    }
}
