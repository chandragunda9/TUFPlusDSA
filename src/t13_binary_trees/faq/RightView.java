package t13_binary_trees.faq;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preOrder(root, ans, 0);
        return ans;
    }

    void preOrder(TreeNode root, List<Integer> ds, int level) {
        if (root == null)
            return;
        if (ds.size() == level) {
            ds.add(root.data);
        }
        ds.add(root.data);
        preOrder(root.right, ds, level + 1);
        preOrder(root.left, ds, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.right.left = new TreeNode(60);
        RightView obj = new RightView();
        System.out.println(obj.rightSideView(root));
    }
}
