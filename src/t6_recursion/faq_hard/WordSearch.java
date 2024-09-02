package t6_recursion.faq_hard;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int start = 0; //searching from first char of word
        int n = board.length, m = board[0].length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (check(row, col, start, word, board, board.length, board[0].length))
                    return true;
            }
        }
        return false;
    }

    boolean check(int row, int col, int ind, String word, char[][] board, int n, int m) {
        if (ind == word.length())
            return true;
        if (row < 0 || row == n || col < 0 || col == m || board[row][col] != word.charAt(ind))
            return false;
        char temp = board[row][col];
        board[row][col] = '.';
        boolean isWordThere = check(row, col - 1, ind + 1, word, board, n, m) ||
                check(row, col + 1, ind + 1, word, board, n, m) ||
                check(row - 1, col, ind + 1, word, board, n, m) ||
                check(row + 1, col, ind + 1, word, board, n, m);

        board[row][col] = temp;
        return isWordThere;
    }

    public static void main(String[] args) {
        char[][] grid = {{'A'}};
        String word = "A";
        WordSearch obj = new WordSearch();
        System.out.println(obj.exist(grid, word));
    }
}
