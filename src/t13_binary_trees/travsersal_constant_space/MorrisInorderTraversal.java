package t13_binary_trees.travsersal_constant_space;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal {
    public List<Integer> getInorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                ans.add(curr.data);
                curr = curr.right;
            } else {
                //lastNode in left subtree
                TreeNode lastNode = curr.left;
                while (lastNode.right != null && lastNode.right != curr) {
                    lastNode = lastNode.right;
                }
                if (lastNode.right == null) {
                    lastNode.right = curr;
                    curr = curr.left;
                } else {
                    lastNode.right = null;
                    ans.add(curr.data);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}
