package t14_binary_search_trees.medium;

public class DeleteAGivenNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            //case 1: single child or no children
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //case 2: both children
            root.data = findMin(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    public TreeNode deleteNode1(TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.data == key) {
            return helper(root);
        }
        TreeNode dupRoot = root;
        while (root != null) {
            if (key < root.data) {
                if (root.left != null && key == root.left.data) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && key == root.right.data) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dupRoot;
    }

    public TreeNode helper(TreeNode root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastNodeInLeft = findMaxNode(root.left);
        lastNodeInLeft.right = rightChild;
        return root.left;
    }

    public TreeNode findMaxNode(TreeNode root) {
        if (root.right == null)
            return root;
        return findMaxNode(root.right);
    }
}
