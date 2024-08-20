package t15_graphs.hard_problems_2;

import t15_graphs.mst.DisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        List<Integer> ans = new ArrayList<>();
        DisjointSet dis = new DisjointSet(n * m);
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        int[][] mat = new int[n][m];

        int noOfIslands = 0;
        for (int i = 0; i < A.length; i++) {
            int row = A[i][0], col = A[i][1];
            if (mat[row][col] == 1) {
                ans.add(noOfIslands);
                continue;
            }
            mat[row][col] = 1;
            noOfIslands++;
            for (int j = 0; j < dRow.length; j++) {
                int nRow = row + dRow[j];
                int nCol = col + dCol[j];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    if (mat[nRow][nCol] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = nRow * m + nCol;
                        if (dis.findParent(nodeNo) != dis.findParent(adjNodeNo)) {
                            dis.unionBySize(nodeNo, adjNodeNo);
                            noOfIslands--;
                        }
                    }
                }
            }
            ans.add(noOfIslands);
        }
        return ans;
    }
}
