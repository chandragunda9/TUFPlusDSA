package arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, n = nums1.length, m = nums2.length;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
