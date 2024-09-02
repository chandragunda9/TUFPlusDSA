package t6_recursion.faq_hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(".".repeat(n));
        List<String> curr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curr.add(sb.toString());
        }
        boolean[] rowMapping = new boolean[n], ldMapping = new boolean[2 * n - 1],
                udMapping = new boolean[2 * n - 1];
        solve(0, n, curr, rowMapping, ldMapping, udMapping, ans);
        return ans;
    }

    boolean canPlaceQueen(int row, int col, int n, boolean[] rowMapping, boolean[] ldMapping, boolean[] udMapping) {
        return !rowMapping[row] && !ldMapping[row + col] && !udMapping[n - 1 + col - row];
    }

    void solve(int col, int n, List<String> curr, boolean[] rowMapping, boolean[] ldMapping, boolean[] udMapping,
               List<List<String>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (canPlaceQueen(row, col, n, rowMapping, ldMapping, udMapping)) {
                rowMapping[row] = true;
                ldMapping[row + col] = true;
                udMapping[n - 1 + col - row] = true;
                curr.set(row, curr.get(row).substring(0, col) + 'Q' + curr.get(row).substring(col + 1));
                solve(col + 1, n, curr, rowMapping, ldMapping, udMapping, ans);
                curr.set(row, curr.get(row).substring(0, col) + '.' + curr.get(row).substring(col + 1));
                rowMapping[row] = false;
                ldMapping[row + col] = false;
                udMapping[n - 1 + col - row] = false;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] rowMapping = new boolean[n], ldMapping = new boolean[2 * n - 1],
                udMapping = new boolean[2 * n - 1];
        ArrayList<Integer> currPlacement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            currPlacement.add(0);
        }
        solve2(0, n, currPlacement, rowMapping, ldMapping, udMapping, ans);
        return ans;
    }

    void solve2(int col, int n, ArrayList<Integer> curr, boolean[] rowMapping, boolean[] ldMapping, boolean[] udMapping,
                ArrayList<ArrayList<Integer>> ans) {
        if (col == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (canPlaceQueen(row, col, n, rowMapping, ldMapping, udMapping)) {
                rowMapping[row] = true;
                ldMapping[row + col] = true;
                udMapping[n - 1 + col - row] = true;
                curr.set(col, row + 1);
                solve2(col + 1, n, curr, rowMapping, ldMapping, udMapping, ans);
                curr.set(col, 0);
                rowMapping[row] = false;
                ldMapping[row + col] = false;
                udMapping[n - 1 + col - row] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueen obj = new NQueen();
        int n = 4;
        System.out.println(obj.solveNQueens(n));
        System.out.println(obj.nQueen(n));
    }
}
