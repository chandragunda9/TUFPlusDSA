package t14_binary_search_trees.faqs;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BSTIteratorTwoSum {
    Stack<TreeNode> st;
    boolean isReverse;

    public BSTIteratorTwoSum(TreeNode root, boolean isReverse) {
        this.isReverse = isReverse;
        this.st = new Stack<>();
        pushAll(root);
    }

    void pushAll(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = isReverse ? root.right : root.left;
        }
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public int next() {
        TreeNode top = st.pop();
        if (isReverse) {
            pushAll(top.left);
        } else {
            pushAll(top.right);
        }
        return top.data;
    }
}

public class TwoSum {
    public boolean twoSumBST(TreeNode root, int k) {
        BSTIteratorTwoSum l = new BSTIteratorTwoSum(root, false);
        BSTIteratorTwoSum r = new BSTIteratorTwoSum(root, true);
        int i = l.next();
        int j = r.next();

        while (i < j) {
            if (i + j == k)
                return true;
            else if (i + j < k) {
                i = l.next();
            } else {
                j = r.next();
            }
        }
        return false;
    }

    public boolean method1(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        inorder(root, li);
        int i = 0, j = li.size() - 1;
        while (i < j) {
            int a = li.get(i);
            int b = li.get(j);
            if (a + b == k) {
                return true;
            } else if (a + b < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    void inorder(TreeNode root, List<Integer> li) {
        if (root == null)
            return;
        inorder(root.left, li);
        li.add(root.data);
        inorder(root.right, li);
    }
}
