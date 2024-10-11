package t11_stacks_queues.faqs;

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, total = 0, n = height.length;
        int l = 0, r = n - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (leftMax > height[l]) {
                    total += leftMax - height[l];
                } else
                    leftMax = height[l];
                l++;
            } else {
                if (rightMax > height[r]) {
                    total += rightMax - height[r];
                } else
                    rightMax = height[r];
                r--;
            }
        }
        return total;
    }

    int[] getPrefixMax(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        return prefix;
    }

    int[] getSuffixMax(int[] arr) {
        int n = arr.length;
        int[] suffix = new int[n];
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        return suffix;
    }

    public int method1(int[] height) {
        int n = height.length;
        int[] leftMax = getPrefixMax(height);
        int[] rightMax = getSuffixMax(height);
        int trapped = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] < leftMax[i] && height[i] < rightMax[i]) {
                trapped += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return trapped;
    }
}
