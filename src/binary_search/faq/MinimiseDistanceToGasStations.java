package binary_search.faq;

public class MinimiseDistanceToGasStations {
    public double minimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, arr[i + 1] - arr[i]);
        }
        double low = 0, high = max;
        while (high - low >= 1e-6) {
            double mid = (low + high) / 2;
            if (countGasStations(arr, mid) > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    int countGasStations(int[] arr, double mid) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int dist = arr[i + 1] - arr[i];
            int noOfGasStationsCanPlaceInBetween = (int) (dist / mid);
            if (noOfGasStationsCanPlaceInBetween * mid == dist) {
                noOfGasStationsCanPlaceInBetween--;
            }
            count += noOfGasStationsCanPlaceInBetween;
        }
        return count;
    }
}
