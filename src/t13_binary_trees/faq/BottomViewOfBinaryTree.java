package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.*;

public class BottomViewOfBinaryTree {
    static class Pair {
        TreeNode node;
        int hd;

        public Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<Integer> bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair front = q.poll();
            map.put(front.hd, front.node.data);

            if (front.node.left != null) {
                q.add(new Pair(front.node.left, front.hd - 1));
            }
            if (front.node.right != null) {
                q.add(new Pair(front.node.right, front.hd + 1));
            }
        }
        return new ArrayList<>(map.values());
    }
}
