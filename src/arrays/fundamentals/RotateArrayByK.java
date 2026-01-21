package arrays.fundamentals;

public class RotateArrayByK {
    public void rotateArray1(int[] nums, int r) {
        //By using juggling algorithm
        int n = nums.length;
        r = r % n;
        int gcdValue = findGcd(n, r);
        for (int i = 0; i < gcdValue; i++) {
            int j = i, k, temp = nums[i];
            while (true) {
                k = (j + r) % n;
                if (k == i)
                    break;
                nums[j] = nums[k];
                j = k;
            }
            nums[j] = temp;
        }
    }

    int findGcd(int a, int b) {
        if (b == 0)
            return a;
        return findGcd(b, a % b);
    }

    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverseArray(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
