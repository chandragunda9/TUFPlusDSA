package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

public class CountTotalNodesInCompleteBinaryTree {
    public int method1(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    public void dfs(TreeNode node, int[] count) {
        if (node == null)
            return;
        count[0]++;
        dfs(node.left, count);
        dfs(node.right, count);
    }

    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int getLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    int getRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}
