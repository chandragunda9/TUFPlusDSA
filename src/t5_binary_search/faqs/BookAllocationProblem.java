package t5_binary_search.faqs;

public class BookAllocationProblem {
    int noOfStudents(int[] nums, int mid) {
        int n = nums.length;
        int stu = 1, pagesAssigned = 0;
        for (int i = 0; i < n; i++) {
            if (pagesAssigned + nums[i] <= mid) {
                pagesAssigned += nums[i];
            } else {
                stu++;
                pagesAssigned = nums[i];
            }
        }
        return stu;
    }

    public int findPages(int[] nums, int m) {
        if (nums.length < m)
            return -1;
        int max = Integer.MIN_VALUE, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int ans = 0;
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int stu = noOfStudents(nums, mid);
            if (stu > m) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
//        return low;
        return ans;
    }

    static int f(int[] arr, int mid) {
        int pages = 0, stu = 1;
        for (int i = 0; i < arr.length; i++) {
            if (pages + arr[i] <= mid) {
                pages += arr[i];
            } else {
                stu++;
                pages = arr[i];
            }
        }
        return stu;
    }

    public static long findPages(int n, int[] arr, int m) {
        if (m > n)
            return -1;
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int low = max, high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = f(arr, mid);
            if (count <= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
