package t3_arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1, r = 0;
        while (l >= 0 && r < n) {
            if (nums1[l] > nums2[r]) {
                int t = nums1[l];
                nums1[l] = nums2[r];
                nums2[r] = t;
                l--;
                r++;
            } else
                break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}
