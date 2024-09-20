package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {
    static class Pair {
        TreeNode node;
        int ind;

        public Pair(TreeNode node, int ind) {
            this.node = node;
            this.ind = ind;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int max = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            Pair front = q.peek();
            int size = q.size();
            int min = front.ind, first = -1, last = -1;
            for (int i = 1; i <= size; i++) {
                Pair rem = q.poll();
                int currInd = rem.ind - min;
                if (i == 1) {
                    first = currInd;
                }
                if (i == size) {
                    last = currInd;
                }
                if (rem.node.left != null) {
                    q.add(new Pair(rem.node.left, 2 * currInd + 1));
                }
                if (rem.node.right != null) {
                    q.add(new Pair(rem.node.right, 2 * currInd + 2));
                }
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}
