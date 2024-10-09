package t14_binary_search_trees.theory;

public class SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.data != val) {
            root = val < root.data ? root.left : root.right;
        }
        return root;
    }

    public TreeNode searchBST1(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.data == val)
            return root;
        if (val < root.data)
            return searchBST1(root.left, val);
        return searchBST1(root.right, val);
    }
}
