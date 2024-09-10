package t9_greedy.easy;

public class JumpGameI {
    public boolean method1(int[] nums) {
        return isPossible(0, nums);
    }

    public boolean isPossible(int ind, int[] nums) {
        if (ind == nums.length - 1)
            return true;
        for (int steps = 1; steps <= nums[ind]; steps++) {
            if (isPossible(ind + steps, nums))
                return true;
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxInd)
                return false;
            maxInd = Math.max(maxInd, i + nums[i]);
            if (maxInd >= nums.length - 1)
                return true;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        JumpGameI obj = new JumpGameI();
        System.out.println(obj.canJump(arr));
    }
}
