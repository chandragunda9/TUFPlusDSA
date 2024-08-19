package t15_graphs.shortest_path_algorithms;

import java.util.Arrays;
import java.util.Map;

public class CityWithSmallestNeighbors {
    public int findCity(int n, int m, int edges[][],
                        int distanceThreshold) {
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }
        for (int[] edge : edges) {
            mat[edge[0]][edge[1]] = edge[2];
            mat[edge[1]][edge[0]] = edge[2];
        }
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][via] != Integer.MAX_VALUE && mat[via][j] != Integer.MAX_VALUE) {
                        mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                    }
                }
            }
        }
        int ind = -1, noOfReachableCities = n;
        for (int cityInd = 0; cityInd < n; cityInd++) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (cityInd == adjCity)
                    continue;
                if (mat[cityInd][adjCity] <= distanceThreshold)
                    count++;
            }
            if (count <= noOfReachableCities) {
                ind = cityInd;
                noOfReachableCities = count;
            }
        }
        return ind;
    }
}
