package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.*;

public class PrintAllNodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = mapParents(root);
        return getNodes(parentMap, target, k);
    }

    public List<Integer> getNodes(Map<TreeNode, TreeNode> parentMap, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> nodes = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        int currDistance = 0;

        q.add(target);
        vis.add(target.data);
        while (!q.isEmpty()) {
            if (currDistance == k) {
                while (!q.isEmpty()) {
                    nodes.add(q.poll().data);
                }
                return nodes;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                if (front.left != null && !vis.contains(front.left.data)) {
                    q.add(front.left);
                    vis.add(front.left.data);
                }
                if (front.right != null && !vis.contains(front.right.data)) {
                    q.add(front.right);
                    vis.add(front.right.data);
                }
                TreeNode parentNode = parentMap.get(front);
                if (parentNode != null && !vis.contains(parentNode.data)) {
                    q.add(parentNode);
                    vis.add(parentNode.data);
                }
            }
            currDistance++;
        }
        return nodes;
    }

    public Map<TreeNode, TreeNode> mapParents(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode front = q.poll();
            if (front.left != null) {
                parentMap.put(front.left, front);
                q.add(front.left);
            }
            if (front.right != null) {
                parentMap.put(front.right, front);
                q.add(front.right);
            }
        }
        return parentMap;
    }

    public static TreeNode createTree(List<Integer> nodes, int index) {
        if (index < nodes.size() && nodes.get(index) != null) {
            TreeNode root = new TreeNode(nodes.get(index));
            root.left = createTree(nodes, 2 * index + 1);
            root.right = createTree(nodes, 2 * index + 2);
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Integer> nodes = Arrays.asList(5, 1, 2, 8, 10, 4, 5, null, 6);
        TreeNode root = createTree(nodes, 0);
        TreeNode target = root.left.right;  // Node with value 5
        int k = 3;
        PrintAllNodesAtDistanceK sol = new PrintAllNodesAtDistanceK();
        List<Integer> result = sol.distanceK(root, target, k);
        System.out.println("Nodes at distance " + k + " from target node are: " + result);
    }
}
