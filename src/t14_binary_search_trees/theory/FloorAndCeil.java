package t14_binary_search_trees.theory;

import java.util.ArrayList;
import java.util.List;

public class FloorAndCeil {
    public List<Integer> floorCeilOfBST(TreeNode root, int key) {
        List<Integer> ans = new ArrayList<>();
        ans.add(floor(root, key));
        ans.add(ceil(root, key));
        return ans;
    }

    public Integer floor(TreeNode root, int key) {
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data <= key) {
                ans = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public Integer ceil(TreeNode root, int key) {
        int ans = Integer.MAX_VALUE;
        while (root != null) {
            if (root.data >= key) {
                ans = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
