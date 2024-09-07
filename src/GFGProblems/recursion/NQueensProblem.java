package GFGProblems.recursion;

import java.util.ArrayList;

public class NQueensProblem {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        boolean[] rowMapping = new boolean[n];
        boolean[] ldMapping = new boolean[2 * n - 1];
        boolean[] udMapping = new boolean[2 * n - 1];
        ArrayList<Integer> curr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        generate(0, n, rowMapping, ldMapping, udMapping, curr, ans);
        return ans;
    }

    boolean canBePlaced(int row, int col, int n, boolean[] rowMapping, boolean[] ldMapping, boolean[] udMapping) {
        return !rowMapping[row] && !ldMapping[row + col] && !udMapping[n - 1 + col - row];
    }

    void generate(int colInd, int n, boolean[] rowMapping, boolean[] ldMapping, boolean[] udMapping,
                  ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans) {
        if (colInd == n) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int row = 0; row < n; row++) {
            if (canBePlaced(row, colInd, n, rowMapping, ldMapping, udMapping)) {
                curr.add(row + 1);
                rowMapping[row] = true;
                ldMapping[row + colInd] = true;
                udMapping[n - 1 + colInd - row] = true;
                generate(colInd + 1, n, rowMapping, ldMapping, udMapping, curr, ans);
                curr.remove(curr.size() - 1);
                rowMapping[row] = false;
                ldMapping[row + colInd] = false;
                udMapping[n - 1 + colInd - row] = false;
            }
        }
    }

    public static void main(String[] args) {
        NQueensProblem obj = new NQueensProblem();
        int n = 4;
        System.out.println(obj.nQueen(n));
    }
}
