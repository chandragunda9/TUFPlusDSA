package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class MaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxSum(root, ans);
        return ans[0];
    }

    int maxSum(TreeNode root, int[] ans) {
        if (root == null)
            return 0;
        int left = Math.max(0, maxSum(root.left, ans));
        int right = Math.max(0, maxSum(root.right, ans));
        ans[0] = Math.max(ans[0], left + right + root.data);
        return root.data + Math.max(left, right);
    }
}
