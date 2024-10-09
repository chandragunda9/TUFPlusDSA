package t14_binary_search_trees.faqs;

import java.util.Stack;

class BSTIterator {
    Stack<TreeNode> st;

    public BSTIterator(TreeNode root) {
        this.st = new Stack<>();
        pushAll(root);
    }

    void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode top = st.pop();
        pushAll(top.right);
        return top.data;
    }
}