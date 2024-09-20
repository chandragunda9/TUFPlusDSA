package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {
    public TreeNode method1(TreeNode root, TreeNode p, TreeNode q) {
        //finding path1 for searching q
        List<TreeNode> path1 = new ArrayList<>();
        findPath(root, p, path1);
        //finding path2 for searching q
        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, q, path2);

        if (path1.isEmpty() || path2.isEmpty())
            return null;
        System.out.println(path1);
        System.out.println(path2);
        int size = Math.min(path1.size(), path2.size());
        int i;
        for (i = 0; i < size; i++) {
            if (path1.get(i) != path2.get(i))
                break;
        }
        return path1.get(i - 1);
    }

    boolean findPath(TreeNode node, TreeNode target, List<TreeNode> path) {
        if (node == null)
            return false;
        path.add(node);
        if (node == target)
            return true;
        boolean left = findPath(node.left, target, path);
        if (left)
            return true;
        boolean right = findPath(node.right, target, path);
        if (right)
            return true;
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        LowestCommonAncestor obj = new LowestCommonAncestor();
        System.out.println(obj.lowestCommonAncestor(root, root.left.left, root.left.right));
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;
        //if it is given that both nodes will exists in tree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null) {
            return left;
        } else {
            return root;
        }
    }
}
