package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.data != right.data)
            return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
