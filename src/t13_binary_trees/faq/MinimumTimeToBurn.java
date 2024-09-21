package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.*;

public class MinimumTimeToBurn {
    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode targetNode = getParentMapping(root, start, parentMap);
        return findTimeToBurn(targetNode, parentMap);
    }

    public int findTimeToBurn(TreeNode targetNode, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        int time = 0;

        q.add(targetNode);
        vis.add(targetNode.data);
        while (!q.isEmpty()) {
            int size = q.size();
            boolean anyAdjacentNodes = false;
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                if (front.left != null && !vis.contains(front.left.data)) {
                    q.add(front.left);
                    vis.add(front.left.data);
                    anyAdjacentNodes = true;
                }
                if (front.right != null && !vis.contains(front.right.data)) {
                    q.add(front.right);
                    vis.add(front.right.data);
                    anyAdjacentNodes = true;
                }
                TreeNode parentNode = parentMap.get(front);
                if (parentNode != null && !vis.contains(parentNode.data)) {
                    q.add(parentNode);
                    vis.add(parentNode.data);
                    anyAdjacentNodes = true;
                }
            }
            if (anyAdjacentNodes)
                time++;
        }
        return time;
    }

    public TreeNode getParentMapping(TreeNode root, int target, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode targetNode = new TreeNode(-1);
        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (front.data == target) {
                targetNode = front;
            }
            if (front.left != null) {
                q.add(front.left);
                parentMap.put(front.left, front);
            }
            if (front.right != null) {
                q.add(front.right);
                parentMap.put(front.right, front);
            }
        }
        return targetNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        int start = 4;
        MinimumTimeToBurn obj = new MinimumTimeToBurn();
        System.out.println(obj.timeToBurnTree(root, start));
    }
}
