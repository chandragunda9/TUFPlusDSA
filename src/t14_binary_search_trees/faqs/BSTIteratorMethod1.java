package t14_binary_search_trees.faqs;

import java.util.ArrayList;
import java.util.List;

class BSTIteratorMethod1 {
    int pointer = -1;
    List<Integer> li = new ArrayList<>();

    public BSTIteratorMethod1(TreeNode root) {
        inorderTraversal(root);
    }

    public boolean hasNext() {
        return pointer + 1 < li.size();
    }

    public int next() {
        return li.get(++pointer);
    }

    void inorderTraversal(TreeNode root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        li.add(root.data);
        inorderTraversal(root.right);
    }
}