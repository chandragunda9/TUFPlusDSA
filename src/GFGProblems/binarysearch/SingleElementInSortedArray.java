package GFGProblems.binarysearch;

public class SingleElementInSortedArray {
    public static int search(int n, int arr[]) {
        if (n == 1)
            return arr[0];
        if (arr[0] != arr[1])
            return arr[0];
        if (arr[n - 1] != arr[n - 2])
            return arr[n - 1];

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1])
                return arr[mid];
            if (((mid & 1) != 0 && arr[mid] == arr[mid - 1]) ||
                    (((mid & 1) == 0) && arr[mid] == arr[mid + 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 5, 5};
        System.out.println(search(arr.length, arr));
    }
}
