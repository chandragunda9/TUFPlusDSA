package binary_search.logic_building;

import java.util.ArrayList;

public class FindOutHowManyTimesArrayIsRotated {
    public int findKRotation(ArrayList<Integer> nums) {
        int low = 0, high = nums.size() - 1, ans = Integer.MAX_VALUE, index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums.get(mid) <= nums.get(high)) {
                high = mid - 1;
                if (nums.get(mid) < ans) {
                    ans = nums.get(mid);
                    index = mid;
                }
            } else {
                low = mid + 1;
                if (nums.get(low) < ans) {
                    ans = nums.get(low);
                    index = low;
                }
            }
        }
        return index;
    }
}
