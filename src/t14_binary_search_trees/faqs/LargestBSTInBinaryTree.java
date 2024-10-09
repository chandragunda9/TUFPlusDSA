package t14_binary_search_trees.faqs;

class NodeVal {
    int largest;
    int smallest;
    int maxSize;

    public NodeVal(int smallest, int largest, int maxSize) {
        this.smallest = smallest;
        this.largest = largest;
        this.maxSize = maxSize;
    }
}

public class LargestBSTInBinaryTree {
    public int largestBST(TreeNode root) {
        return postOrder(root).maxSize;
    }

    public NodeVal postOrder(TreeNode root) {
        if (root == null) {
            //such that largest coming from the left would be MIN_VALUE or
            // smallest coming from the right would be MAX_VALUE
            return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeVal left = postOrder(root.left);
        NodeVal right = postOrder(root.right);
        //checking if root's value > largest value in left subtree and root's value< smallest value in right subtree
        if (left.largest < root.data && root.data < right.smallest) {
            //is a valid BST substree
            return new NodeVal(Math.min(root.data, left.smallest),
                    Math.max(root.data, right.largest), left.maxSize + right.maxSize + 1);
        }

        return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}
