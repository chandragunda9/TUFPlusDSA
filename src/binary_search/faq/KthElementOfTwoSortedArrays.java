package binary_search.faq;

public class KthElementOfTwoSortedArrays {
    public int kthElement(int[] arr1, int[] arr2, int k) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n2 < n1)
            return kthElement(arr2, arr1, k);
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : arr2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }
        return -1;
    }
}
