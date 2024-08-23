package t3_arrays.logic_building;

import java.util.ArrayList;
import java.util.List;

public class UnionOfTwoSortedArrays {
    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums1[i]) {
                    ans.add(nums1[i]);
                }
                i++;
            } else {
                if (ans.isEmpty() || ans.get(ans.size() - 1) != nums2[j]) {
                    ans.add(nums2[j]);
                }
                j++;
            }
        }
        while (i < nums1.length) {
            if (ans.get(ans.size() - 1) != nums1[i])
                ans.add(nums1[i]);
            i++;
        }
        while (j < nums2.length) {
            if (ans.get(ans.size() - 1) != nums2[j])
                ans.add(nums2[j]);
            j++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
