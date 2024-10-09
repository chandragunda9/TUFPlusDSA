package t14_binary_search_trees.faqs;

public class CorrectNodesWithTwoNodesSwapped {
    TreeNode prev;
    TreeNode first;
    TreeNode middle;
    TreeNode last;

    void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        middle = null;
        last = null;
        inorder(root);
        if (first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if (first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && root.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
