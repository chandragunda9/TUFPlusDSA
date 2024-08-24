package t5_binary_search.logic_building;

import java.util.ArrayList;

public class NoOfTimesSortedArrayRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1, ans = Integer.MAX_VALUE, ind = -1;
        while (low <= high) {
            if (nums.get(low) <= nums.get(high)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    ind = low;
                    break;
                }
            }
            int mid = (low + high) / 2;
            if (nums.get(low) <= nums.get(mid)) {
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    ind = low;
                }
                low = mid + 1;
            } else {
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    ind = mid;
                }
                high = mid - 1;
            }
        }
        return ind;
    }
}
