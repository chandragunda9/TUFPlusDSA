package t3_arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
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
