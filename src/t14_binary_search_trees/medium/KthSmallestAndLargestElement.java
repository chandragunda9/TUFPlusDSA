package t14_binary_search_trees.medium;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestAndLargestElement {
    int counter;
    int result;

    public List<Integer> kLargesSmall(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        ans.add(kthSmallest(root, k));
        ans.add(kthLargest(root, k));
        return ans;
    }

    int kthSmallest(TreeNode root, int k) {
        this.counter = k;
        this.result = -1;
        inOrder(root);
        return result;
    }

    int kthLargest(TreeNode root, int k) {
        this.counter = k;
        this.result = -1;
        revInOrder(root);
        return result;
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (--counter == 0) {
            result = root.data;
            return;
        }
        inOrder(root.right);
    }

    void revInOrder(TreeNode root) {
        if (root == null)
            return;
        revInOrder(root.right);
        if (--counter == 0) {
            result = root.data;
            return;
        }
        revInOrder(root.left);
    }
}
