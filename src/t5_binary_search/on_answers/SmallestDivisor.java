package t5_binary_search.on_answers;

public class SmallestDivisor {
    int f1(int[] nums, int mid, int limit) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid)
                sum = sum + 1;
            else
//                sum = (int) (sum + Math.ceil((double) nums[i] / mid));
                sum += Math.ceil((double) nums[i] / mid);
            if (sum > limit)
                return 2;
        }
        if (sum == limit)
            return 1;
        return 0;
    }

    int f(int[] nums, int mid, int limit) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid)
                sum = sum + 1;
            else
                sum += Math.ceil((double) nums[i] / mid);
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int limit) {
        int maxi = Integer.MIN_VALUE;
        for (int num : nums) {
            maxi = Math.max(maxi, num);
        }
        int low = 1, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = f(nums, mid, limit);
            if (res <= limit)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        SmallestDivisor obj = new SmallestDivisor();
        int[] nums = {8, 4, 2, 3};
        int limit = 17;
        System.out.println(obj.smallestDivisor(nums, limit));
    }
}
