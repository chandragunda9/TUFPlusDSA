package t5_binary_search.faqs;

public class MedianOfTwoSortedArrays {
    public double median(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        if (n1 > n2)
            return median(arr2, arr1);
        int low = 0, high = n1;
        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : arr2[cut2];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else if (l2 > r1) {
                low = cut1 + 1;
            }
        }
        return -1;
    }

    public double method1(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length, n = n1 + n2;
        int ind2 = n / 2, ind1 = ind2 - 1;
        int ele1 = Integer.MAX_VALUE, ele2 = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int pointer = 0;
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (pointer == ind1) ele1 = arr1[i];
                if (pointer == ind2) ele2 = arr1[i];
                pointer++;
                i++;
            } else {
                if (pointer == ind1) ele1 = arr2[j];
                if (pointer == ind2) ele2 = arr2[j];
                pointer++;
                j++;
            }
            if (ele1 != Integer.MAX_VALUE && ele2 != Integer.MAX_VALUE)
                break;
        }

        while (i < n1) {
            if (pointer == ind1) ele1 = arr1[i];
            if (pointer == ind2) ele2 = arr1[i];
            pointer++;
            i++;
            if (ele1 != Integer.MAX_VALUE && ele2 != Integer.MAX_VALUE)
                break;
        }
        while (j < n2) {
            if (pointer == ind1) ele1 = arr2[j];
            if (pointer == ind2) ele2 = arr2[j];
            pointer++;
            j++;
            if (ele1 != Integer.MAX_VALUE && ele2 != Integer.MAX_VALUE)
                break;
        }

        if (n % 2 == 0)
            return (double) (ele1 + ele2) / 2;
        return ele2;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 6}, arr2 = {1, 3, 5};
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        System.out.println(obj.method1(arr1, arr2));
    }
}
