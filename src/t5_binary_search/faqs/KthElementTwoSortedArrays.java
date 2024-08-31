package t5_binary_search.faqs;

public class KthElementTwoSortedArrays {
    public int kthElement(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        if (n1 > n2)
            return kthElement(b, a, k);
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int l1 = (cut1 > 0) ? a[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = (cut2 > 0) ? b[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = (cut1 < n1) ? a[cut1] : Integer.MAX_VALUE;
            int r2 = (cut2 < n2) ? b[cut2] : Integer.MAX_VALUE;
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

    public long kthElement(int k, int arr1[], int arr2[]) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2) {
            return kthElement(k, arr2, arr1);
        }
        int low = Math.max(0, k - n2), high = Math.min(k, n1);
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = k - cut1;
            int l1 = (cut1 > 0) ? arr1[cut1 - 1] : Integer.MIN_VALUE;
            int l2 = (cut2 > 0) ? arr2[cut2 - 1] : Integer.MIN_VALUE;
            int r1 = (cut1 < n1) ? arr1[cut1] : Integer.MAX_VALUE;
            int r2 = (cut2 < n2) ? arr2[cut2] : Integer.MAX_VALUE;
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
