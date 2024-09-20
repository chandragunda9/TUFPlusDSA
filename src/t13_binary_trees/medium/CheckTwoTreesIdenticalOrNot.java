package t13_binary_trees.medium;

import t13_binary_trees.TreeNode;

public class CheckTwoTreesIdenticalOrNot {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return p == q;
        if (p.data != q.data)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.left, q.left);
    }
}
