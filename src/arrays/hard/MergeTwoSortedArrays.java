package arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = m - 1, left = 0;
        while (right >= 0 && left < n) {
            if (nums1[right] > nums2[left]) {
                int temp = nums1[right];
                nums1[right] = nums2[left];
                nums2[left] = temp;
                right--;
                left++;
            } else
                break;
        }
        Arrays.sort(nums1, 0, m);
        Arrays.sort(nums2);

        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[i - m];
        }
    }
}
