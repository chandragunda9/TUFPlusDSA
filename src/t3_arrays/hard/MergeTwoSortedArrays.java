package t3_arrays.hard;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void method1(int[] nums1, int m, int[] nums2, int n) {
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

    void swapIfGreater(int[] a, int[] b, int i, int j) {
        if (a[i] > b[j]) {
            int t = a[i];
            a[i] = b[j];
            b[j] = t;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //By using Gap method
        int len = m + n;
        int gap = len / 2 + len % 2;
        while (gap > 0) {
            int left = 0, right = left + gap;
            while (right < len) {
                //if one is in left arr and other in right array
                if (left < m && right >= m) {
                    swapIfGreater(nums1, nums2, left, right - m);
                } else if (right < m) {
                    swapIfGreater(nums1, nums1, left, right);
                } else {
                    swapIfGreater(nums2, nums2, left - m, right - m);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = gap / 2 + gap % 2;
        }

        for (int i = m; i < len; i++) {
            nums1[i] = nums2[i - m];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {-5, -2, 4, 5, 0, 0, 0}, nums2 = {-3, 1, 8};
        MergeTwoSortedArrays obj = new MergeTwoSortedArrays();
        obj.merge(nums1, 4, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
