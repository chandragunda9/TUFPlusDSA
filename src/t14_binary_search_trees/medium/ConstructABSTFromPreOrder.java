package t14_binary_search_trees.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructABSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] ind = new int[1];
        return helper(preorder, Integer.MAX_VALUE, ind);
    }

    public TreeNode helper(int[] preorder, int maxBound, int[] index) {
        if (index[0] == preorder.length || preorder[index[0]] > maxBound)
            return null;
        TreeNode root = new TreeNode(preorder[index[0]++]);
        root.left = helper(preorder, root.data - 1, index);
        root.right = helper(preorder, maxBound, index);
        return root;
    }

    public TreeNode method2(int[] preorder) {
        int[] inorder = Arrays.stream(preorder).sorted().toArray();
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1,
                0, inorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd,
                              int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRootIndex = map.get(root.data);
        int numsLeft = inRootIndex - inStart;
        root.left = buildTree(preOrder, inOrder, preStart + 1, preStart + numsLeft,
                inStart, inRootIndex - 1, map);
        root.right = buildTree(preOrder, inOrder, preStart + numsLeft + 1, preEnd,
                inRootIndex + 1, inEnd, map);
        return root;
    }

    public TreeNode method1(int[] preorder) {
        TreeNode root = null;
        for (int nodeVal : preorder) {
            root = insertNode(root, nodeVal);
        }
        return root;
    }

    public TreeNode insertNode(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null)
            return node;
        TreeNode dupRoot = root;
        while (true) {
            if (val < root.data) {
                if (root.left == null) {
                    root.left = node;
                    break;
                } else {
                    root = root.left;
                }
            } else if (val > root.data) {
                if (root.right == null) {
                    root.right = node;
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dupRoot;
    }
}
