package t14_binary_search_trees.medium;

import java.util.ArrayList;
import java.util.List;

public class LCAInABST {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null)
            return null;
        if (p < root.data && q < root.data) {
            return lca(root.left, p, q);
        } else if (p > root.data && q > root.data) {
            return lca(root.right, p, q);
        }
        return root;
    }

    public TreeNode lca2(TreeNode root, int p, int q) {
        while (root != null) {
            if (p < root.data && q < root.data) {
                root = root.left;
            } else if (p > root.data && q > root.data) {
                root = root.right;
            } else
                break;
        }
        return root;
    }

    public TreeNode lca1(TreeNode root, int p, int q) {
        List<TreeNode> path1 = new ArrayList<>();
        findPath(root, path1, p);

        List<TreeNode> path2 = new ArrayList<>();
        findPath(root, path2, q);

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i))
                break;
        }
        return path1.get(i - 1);
    }

    boolean findPath(TreeNode root, List<TreeNode> path, int val) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == val)
            return true;
        if (findPath(root.left, path, val) || findPath(root.right, path, val)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}
