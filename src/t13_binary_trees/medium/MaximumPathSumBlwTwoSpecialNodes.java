package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class MaximumPathSumBlwTwoSpecialNodes {
    int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxSum(root, root, ans);
        return ans[0];
    }

    int maxSum(TreeNode node, TreeNode root, int[] ans) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return node.data;
        int leftMaxSum = maxSum(node.left, root, ans);
        if (node.left != null && node.right == null) {
            if (node == root) {
                ans[0] = Math.max(ans[0], leftMaxSum + node.data);
            }
            return leftMaxSum + node.data;
        }
        int rightMaxSum = maxSum(node.right, root, ans);
        if (node.left == null && node.right != null) {
            if (node == root) {
                ans[0] = Math.max(ans[0], node.data + rightMaxSum);
            }
            return node.data + rightMaxSum;
        }
        ans[0] = Math.max(ans[0], leftMaxSum + node.data + rightMaxSum);
        return node.data + Math.max(leftMaxSum, rightMaxSum);
    }
}
