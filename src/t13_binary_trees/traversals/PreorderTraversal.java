package t13_binary_trees.traversals;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode top = st.pop();
            ans.add(top.data);
            if (top.right != null)
                st.push(top.right);
            if (top.left != null)
                st.push(top.left);
        }
        return ans;
    }

    public List<Integer> method1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recPreOrder(root, ans);
        return ans;
    }

    public void recPreOrder(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.data);
        recPreOrder(root.left, ans);
        recPreOrder(root.right, ans);
    }
}
