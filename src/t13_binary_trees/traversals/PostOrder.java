package t13_binary_trees.traversals;

import t13_binary_trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        getPostOrder(root, nodes);
        return nodes;
    }

    public void getPostOrder(TreeNode node, List<Integer> nodes) {
        if (node == null)
            return;
        getPostOrder(node.left, nodes);
        getPostOrder(node.right, nodes);
        nodes.add(node.data);
    }
}
