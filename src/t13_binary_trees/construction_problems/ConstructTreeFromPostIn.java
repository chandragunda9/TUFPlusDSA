package t13_binary_trees.construction_problems;

import t13_binary_trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPostIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inOrder, int inStart, int inEnd,
                              int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postOrder[postEnd]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(inOrder, inStart, inRoot - 1,
                postOrder, postStart, postStart + numsLeft - 1, map);
        root.right = buildTree(inOrder, inRoot + 1, inEnd,
                postOrder, postStart + numsLeft, postEnd - 1, map);
        return root;
    }
}
