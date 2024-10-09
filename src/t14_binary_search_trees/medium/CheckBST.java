package t14_binary_search_trees.medium;

public class CheckBST {
    public boolean isBST(TreeNode root) {
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return validate(root, min, max);
    }

    public boolean validate(TreeNode root, int min, int max) {
        if (root == null)
            return true;
        if (root.data < min || root.data > max)
            return false;
        boolean left = validate(root.left, min, root.data - 1);
        boolean right = validate(root.right, root.data + 1, max);
        return left && right;
    }
}
