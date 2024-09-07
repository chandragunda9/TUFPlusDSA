package GFGProblems.recursion;

public class MColoringProblem {
    public boolean graphColoring(boolean graph[][], int m, int n) {
        int[] colorsFilled = new int[n];
        return check(0, colorsFilled, m, graph);
    }

    boolean isPossible(int v, int color, int[] colorsFilled, boolean[][] graph) {
        boolean[] conn = graph[v];
        for (int i = 0; i < conn.length; i++) {
            if (conn[i] && colorsFilled[i] == color)
                return false;
        }
        return true;
    }

    boolean check(int node, int[] colorsFilled, int m, boolean[][] graph) {
        if (node == graph.length)
            return true;
        for (int col = 1; col <= m; col++) {
            if (isPossible(node, col, colorsFilled, graph)) {
                colorsFilled[node] = col;
                if (check(node + 1, colorsFilled, m, graph))
                    return true;
                colorsFilled[node] = 0;
            }
        }
        return false;
    }
}
