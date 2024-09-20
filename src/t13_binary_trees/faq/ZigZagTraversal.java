package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToDir = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> row = new ArrayList<>(Collections.nCopies(size, 0));
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                int ind = leftToDir ? i : size - 1 - i;
                row.set(ind, front.data);
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }
            ans.add(row);
            leftToDir = !leftToDir;
        }
        return ans;
    }
}
