package t5_binary_search.faqs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimiseMaxDistToGasStations {
    int noOfGasStationsRequired(int[] arr, double mid) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            int noOfGasStationsCanPlaceInBetween = (int) ((arr[i] - arr[i - 1]) / mid);
            if (arr[i] - arr[i - 1] == noOfGasStationsCanPlaceInBetween * mid)
                noOfGasStationsCanPlaceInBetween--;
            count += noOfGasStationsCanPlaceInBetween;
        }
        return count;
    }

    public double minimiseMaxDistance(int[] arr, int k) {
        double mod = 1e-6;
        int n = arr.length;
        int maxDist = 0;
        for (int i = 1; i < n; i++) {
            maxDist = Math.max(maxDist, arr[i] - arr[i - 1]);
        }
        double low = 0, high = maxDist;
        while (high - low >= mod) {
            double mid = (low + high) / 2;
            int count = noOfGasStationsRequired(arr, mid);
            if (count > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    public double method1(int[] arr, int k) {
        int n = arr.length;
        int[] howManyPlaced = new int[n - 1];
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            int maxInd = -1;
            double maxSecLength = 0;
            for (int i = 0; i < n - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                double sectionLength = (double) diff / (howManyPlaced[i] + 1);
                if (sectionLength > maxSecLength) {
                    maxSecLength = sectionLength;
                    maxInd = i;
                }
            }
            howManyPlaced[maxInd]++;
        }
        double max = 0;
        for (int i = 0; i < n - 1; i++) {
            double sectionLen = (double) (arr[i + 1] - arr[i]) / (howManyPlaced[i] + 1);
            if (sectionLen > max)
                max = sectionLen;
        }
        return max;
    }

    static class Pair {
        double secLen;
        int ind;

        public Pair(double secLen, int ind) {
            this.secLen = secLen;
            this.ind = ind;
        }

        public double getSecLen() {
            return secLen;
        }
    }

    public double method2(int[] arr, int k) {
        int n = arr.length;
        int[] howManyPlaced = new int[n - 1];
//        Queue<Pair> q = new PriorityQueue<>((o1, o2) -> Double.compare(o2.secLen, o1.secLen));
//        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingDouble(Pair::getSecLen).reversed());
        Comparator<Pair> comp = (o1, o2) -> {
            if (Double.compare(o2.getSecLen(), o1.getSecLen()) == 0)
                return Integer.compare(o2.ind, o1.ind);
            return Double.compare(o2.getSecLen(), o1.getSecLen());
        };
        Queue<Pair> q = new PriorityQueue<>(comp);
        for (int i = 0; i < n - 1; i++) {
            q.add(new Pair(arr[i + 1] - arr[i], i));
        }
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            //getting the max section length
            Pair top = q.poll();
            int ind = top.ind;
            double secLen = top.secLen;
            howManyPlaced[top.ind] += 1;
            double newSecLen = (double) (arr[ind + 1] - arr[ind]) / (howManyPlaced[ind] + 1);
            q.add(new Pair(newSecLen, ind));
        }
        return q.peek().secLen;
    }

    public static void main(String[] args) {
        MinimiseMaxDistToGasStations obj = new MinimiseMaxDistToGasStations();
        int[] arr = {3, 6, 12, 19, 33, 44, 67, 72, 89, 95};
        int k = 2;
        System.out.println(obj.minimiseMaxDistance(arr, k));
    }

    public static double findSmallestMaxDist(int arr[], int k) {
        int maxDiff = 0;
        double mod = 1e-6;
        for (int i = 0; i < arr.length - 1; i++) {
            maxDiff = Math.max(maxDiff, arr[i + 1] - arr[i]);
        }
        double low = 0, high = maxDiff;
        while (high - low >= mod) {
            double mid = (low + high) / 2;
            int count = f(arr, mid);
            if (count <= k) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    static int f(int[] arr, double mid) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            int noOfStationsInBetween = (int) (diff / mid);
            if (noOfStationsInBetween * mid == diff) {
                noOfStationsInBetween--;
            }
            count += noOfStationsInBetween;
        }
        return count;
    }
}
