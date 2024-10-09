package t14_binary_search_trees.medium;


public class InsertAGivenNodeInBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode curr = root;
        while (true) {
            if (val < curr.data) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = node;
                    break;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = node;
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode insertIntoBST1(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        if (val < root.data) {
            root.left = insertIntoBST1(root.left, val);
        } else if (val > root.data) {
            root.right = insertIntoBST1(root.right, val);
        }
        return root;
    }
}
