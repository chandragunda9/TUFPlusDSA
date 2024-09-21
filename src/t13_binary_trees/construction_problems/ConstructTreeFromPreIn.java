package t13_binary_trees.construction_problems;

import t13_binary_trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromPreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, preorder.length - 1,
                0, inorder.length - 1, preorder, inorder, map);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd,
                              int[] preOrder, int[] inOrder, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(root.data);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preStart + 1, preStart + numsLeft,
                inStart, inRoot - 1, preOrder, inOrder, map);
        root.right = buildTree(preStart + numsLeft + 1, preEnd, inRoot + 1,
                inEnd, preOrder, inOrder, map);
        return root;
    }
}
