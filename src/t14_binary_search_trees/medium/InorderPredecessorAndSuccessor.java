package t14_binary_search_trees.medium;

import java.util.ArrayList;
import java.util.List;

public class InorderPredecessorAndSuccessor {
    List<Integer> succPredBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(predecessor(root, key));
        ans.add(successor(root, key));
        return ans;
    }

    public Integer successor(TreeNode root, int key) {
        int successor = -1;
        while (root != null) {
            if (root.data > key) {
                successor = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public Integer predecessor(TreeNode root, int key) {
        int predecessor = -1;
        while (root != null) {
            if (root.data < key) {
                predecessor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predecessor;
    }

    List<Integer> method1(TreeNode root, int key) {
        return null;
    }
}
