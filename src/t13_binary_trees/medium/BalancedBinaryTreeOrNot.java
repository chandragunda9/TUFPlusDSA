package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class BalancedBinaryTreeOrNot {
    public boolean isBalancedTree(TreeNode root) {
        if (root == null)
            return true;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        return Math.abs(lHeight - rHeight) <= 1 && isBalancedTree(root.left) && isBalancedTree(root.right);
    }

    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int lHeight = getHeight(root.left);
        int rHeight = getHeight(root.right);
        return 1 + Math.max(lHeight, rHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left);
        if (lh == -1)
            return -1;
        int rh = height(root.right);
        if (rh == -1)
            return -1;
        if (Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh, rh);
    }
}
