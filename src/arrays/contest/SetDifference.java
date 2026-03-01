package arrays.contest;

import java.util.ArrayList;
import java.util.List;

public class SetDifference {
    public int[] setDifference(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        List<Integer> ans = new ArrayList<>();
        while (i < n && j < m) {
            if (i > 0 && nums1[i] == nums1[i - 1]) {
                i++;
                continue;
            }
            if (j > 0 && nums2[j] == nums2[j - 1]) {
                j++;
                continue;
            }
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                ans.add(nums1[i]);
                i++;
            } else {
                ans.add(nums2[j]);
                j++;
            }
        }

        while (i < n) {
            if (i == 0 || nums1[i] != nums1[i - 1]) {
                ans.add(nums1[i]);

            }
            i++;
        }

        while (j < m) {
            if (j == 0 || nums2[j] != nums2[j - 1]) {
                ans.add(nums2[j]);
            }
            j++;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
