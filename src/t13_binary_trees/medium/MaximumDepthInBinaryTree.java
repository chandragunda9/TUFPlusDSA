package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthInBinaryTree {
    public int method1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 1; i <= size; i++) {
                TreeNode front = q.poll();
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            level++;
        }
        return level;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
