package binary_search.logic_building;

import java.util.ArrayList;

public class FindMinInRotatedSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int low = 0, high = arr.size() - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) <= arr.get(high)) {
                high = mid - 1;
                ans = Math.min(ans, arr.get(mid));
            } else {
                low = mid + 1;
                ans = Math.min(ans, arr.get(low));
            }
        }
        return ans;
    }
}
