package t15_graphs.hard_problems_2;

import java.util.HashSet;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrColumn {
    public int maxRemove(int[][] stones, int n) {
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        Set<Integer> stoneNodes = new HashSet<>();
        DisjointSet dis = new DisjointSet(maxRow + maxCol + 1);
        for (int[] stone : stones) {
            int row = stone[0], col = stone[1] + maxRow + 1;
            dis.unionBySize(row, col);
            stoneNodes.add(row);
            stoneNodes.add(col);
        }
        int noc = 0;
        for (Integer stone : stoneNodes) {
            if (dis.findParent(stone) == stone)
                noc++;
        }
        return n - noc;
    }
}
