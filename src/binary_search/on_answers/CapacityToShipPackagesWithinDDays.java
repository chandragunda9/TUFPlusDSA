package binary_search.on_answers;

public class CapacityToShipPackagesWithinDDays {
    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            boolean res = f(weights, mid, days);
            if (res) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static boolean f(int[] weights, int capacity, int days) {
        long load = 0, used = 1;
        for (int weight : weights) {
            if (load + weight > capacity) {
                used++;
                load = weight;
            } else {
                load = load + weight;
            }
        }
        return used <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(shipWithinDays(weights, days));
    }
}
