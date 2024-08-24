package t5_binary_search.logic_building;

import java.util.ArrayList;

public class MinimumInRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            if (arr.get(low) <= arr.get(high)) {
                ans = Math.min(ans, arr.get(low));
                break;
            }
            int mid = (low + high) / 2;
            if (arr.get(low) <= arr.get(mid)) {
                ans = Math.min(ans, arr.get(low));
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr.get(mid));
                high = mid - 1;
            }
        }
        return ans;
    }

    public int method1(ArrayList<Integer> arr) {
        return findMin(arr, 0, arr.size() - 1);
    }

    public int findMin(ArrayList<Integer> arr, int l, int r) {
        if (l == r)
            return arr.get(l);
        if (l > r)
            return -1;
        if (arr.get(l) <= arr.get(r)) {
            return arr.get(l);
        }
        int mid = (l + r) / 2;
        if (arr.get(l) <= arr.get(mid)) {
            return Math.min(arr.get(l), findMin(arr, mid + 1, r));
        }
        return Math.min(arr.get(mid), findMin(arr, l, mid - 1));
    }
}
