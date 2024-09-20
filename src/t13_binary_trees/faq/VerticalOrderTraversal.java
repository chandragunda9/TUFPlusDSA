package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    static class Tuple {
        TreeNode node;
        int x;
        int y;

        public Tuple(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, Queue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple front = q.poll();
            int x = front.x;
            int y = front.y;
            TreeNode node = front.node;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).add(node.data);

            if (node.left != null) {
                q.add(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, Queue<Integer>> yMap : map.values()) {
            List<Integer> temp = new ArrayList<>();
            for (Queue<Integer> pq : yMap.values()) {
                while (!pq.isEmpty()) {
                    temp.add(pq.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
