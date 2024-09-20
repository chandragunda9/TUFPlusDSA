package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoundaryTraversal {
    public List<Integer> boundary(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (isLeaf(root)) {
            ans.add(root.data);
            return ans;
        }
        ans.add(root.data);
        addLeftView(root, ans);
        addLeaves(root, ans);
        addRightView(root, ans);
        return ans;
    }

    boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    void addLeftView(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) {
                res.add(curr.data);
            }
            if (curr.left == null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }

    void addRightView(TreeNode root, List<Integer> res) {
        List<Integer> temp = new ArrayList<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right == null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        Collections.reverse(temp);
        res.addAll(temp);
    }

    void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }
}
