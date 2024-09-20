package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {
    public List<List<Integer>> allRootToLeaf(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfsTraversal(root, path, ans);
        return ans;
    }

    void dfsTraversal(TreeNode root, List<Integer> path, List<List<Integer>> ans) {
        if (root == null)
            return;
        path.add(root.data);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(path));
        } else {
            dfsTraversal(root.left, path, ans);
            dfsTraversal(root.right, path, ans);
        }
        path.remove(path.size() - 1);
    }
}
