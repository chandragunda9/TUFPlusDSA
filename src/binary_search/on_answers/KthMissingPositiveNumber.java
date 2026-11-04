package binary_search.on_answers;

public class KthMissingPositiveNumber {
    public static int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int noOfMissing = arr[mid] - mid - 1;
            if (noOfMissing >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low + k;
    }

    public static int findKthPositive1(int[] arr, int k) {
        int prev = 0;
        for (int i = 0; i < arr.length; i++) {
            int countMissing = arr[i] - prev - 1;
            if (countMissing >= k) {
                break;
            } else {
                prev = arr[i];
                k -= countMissing;
            }
        }
        return prev + k;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 10};
        int k = 6;
        System.out.println(findKthPositive1(arr, k));
        System.out.println(findKthPositive(arr, k));
    }
}
