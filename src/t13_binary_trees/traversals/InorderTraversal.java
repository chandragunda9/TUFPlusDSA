package t13_binary_trees.traversals;

import java.util.ArrayList;
import java.util.List;

import t13_binary_trees.TreeNode;

public class InorderTraversal {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getInorder(root, nodes);
        return nodes;
    }

    public void getInorder(TreeNode node, List<Integer> nodes) {
        if (node == null)
            return;
        getInorder(node.left, nodes);
        nodes.add(node.data);
        getInorder(node.right, nodes);
    }
}
