package t15_graphs.hard_problems_2;

import t15_graphs.mst.DisjointSet;

public class NumberOfOperationsToMakeConnected {
    public int solve(int n, int[][] Edge) {
//        DisjointSet dis = new DisjointSet(n);
//        int noOfComponents = 0;
//        int extraEdges = 0;
//        for (int[] edge : Edge) {
//            if (dis.findParent(edge[0]) != dis.findParent(edge[1])) {
//                dis.unionBySize(edge[0], edge[1]);
//            } else {
//                extraEdges++;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (dis.findParent(i) == i)
//                noOfComponents++;
//        }
//        int edgesReq = noOfComponents - 1;
//        if (extraEdges >= edgesReq)
//            return edgesReq;
//        return -1;

        if (Edge.length < n - 1)
            return -1;
        DisjointSet dis = new DisjointSet(n);
        int noc = 0;
        for (int[] edge : Edge) {
            dis.unionBySize(edge[0], edge[1]);
        }
        for (int i = 0; i < n; i++) {
            if (dis.findParent(i) == i)
                noc++;
        }
        return noc - 1;
    }
}
