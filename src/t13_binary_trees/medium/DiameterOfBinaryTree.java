package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class DiameterOfBinaryTree {
    public int method1(TreeNode root) {
        if (root == null)
            return 0;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        int ld = method1(root.left);
        int rd = method1(root.right);
        return Math.max(lh + rh, Math.max(ld, rd));
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    public int height(TreeNode root, int[] ans) {
        if (root == null)
            return 0;
        int lh = height(root.left, ans);
        int rh = height(root.right, ans);
        ans[0] = Math.max(ans[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        height(root, ans);
        return ans[0];
    }
}
